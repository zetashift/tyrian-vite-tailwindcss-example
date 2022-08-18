import { defineConfig } from "vite";
import { spawnSync } from "child_process";

function isDev() {
  return process.env.NODE_ENV !== "production";
}

// Through some hoops we get the SBT output,
// this is necessary because there are some slight platform specific things required
function printSbtTask(task) {
  const args = ["--error", "--batch", `print ${task}`];
  const options = {
    stdio: [
      "pipe", // StdIn.
      "pipe", // StdOut.
      "inherit", // StdErr.
    ],
  };
  const result =
    process.platform === "win32"
      ? spawnSync(
          "sbt.bat",
          args.map((x) => `"${x}"`),
          { shell: true, ...options }
        )
      : spawnSync("sbt", args, options);

  if (result.error) throw result.error;
  if (result.status !== 0)
    throw new Error(`sbt process failed with exit code ${result.status}`);
  return result.stdout.toString("utf8").trim();
}

// This is a string representing the directory which contains the Scala.js output file
const linkOutputDir = isDev()
  ? printSbtTask("fastLinkOutputDir")
  : printSbtTask("fullLinkOutputDir");

export default defineConfig({
  resolve: {
    alias: [
      {
        find: "@linkOutputDir",
        replacement: linkOutputDir,
      },
    ],
  },
});
