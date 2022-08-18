# Scala & Tyrian & Tailwind & Vite

NOTE: needs a catchier name

## Getting Started

Make sure you have `sbt` and `node` version 16.x+ installed

First clone the repo and `cd` into it.

`git clone https://github.com/zetashift/tyrian-vite-tailwindcss-example.git  && cd 
 tyrian-vite-tailwindcss-example`

 Then run the command `npm install` to install all the needed packages

 To get a development environment running:
 
 `npm run dev`

 And to get a production bundle, first set a `NODE_ENV` environment variable, use `production` as the value, then run:

 `npm run build`

## About

A very small example of how to get a nice frontend developer experience, using Vite and Scala.

It uses:
- [Scala 3](https://www.scala-lang.org/) & [Scala.js](https://www.scala-js.org/) to compile to JavaScript. And it uses `sbt` as a build tool.
- [Tyrian](https://github.com/PurpleKingdomGames/tyrian) as a frontend UI library.
- [Vite](https://vitejs.dev/) as the bundler/tooling for setting up hot reload and bundling.
- [TailwindCSS](https://tailwindcss.com/) to confuse people with massive amounts of CSS classes in HTML but still feel good about writing CSS.

So the general idea is that `sbt` will produce a JavaScript file from the Scala source code. That script file is then referenced in our `main.js` and is then used.

If an environment variable named `NODE_ENV` is set to `production` then a very optimized JavaScript file will be produced by `sbt and Vite uses it to produce a bundle that's ready to be used where you want!

## Structure

Since this is a mix of Scala, JavaScript and CSS, there are a lot of files and directories!

```
.
├── README
├── src
│   └── main
│       └── scala
│           └── app
│               └── Main.scala
├── vite.config.js
├── .gitignore
├── .scalafmt.conf
├── build.sbt
├── index.html
├── main.js
├── package-lock.json
├── package.json
├── postcss.config.cjs
├── project
│   ├── build.properties
│   └── plugins.sbt
├── public
│   └── vite.svg
├── style.css
└── tailwind.config.cjs
```

- `Main.scala` contains the Tyrian entrypoint.
- `build.sbt` contains the `sbt` configuration.
- `vite.config.js` contains the configuration for Vite.
- `tailwind.config.cjs` contains the Tailwind configuration.


## Thanks

[This helpful video](https://www.youtube.com/watch?v=dv7fPmgFTNA) did 99% of the work!