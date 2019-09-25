# ScrambleGenerator
A customizable random state Rubik's Cube scrambler

This library uses a random state scrambler to generate scrambles for a Rubik's Cube. Instead of constructing a scramble by creating a random sequence of moves, a randomly scrambled representation of a Rubik's Cube is generated and then a solving algortihm is applied to it. The scramble generated is the inverse of the solution. This process is described in detail below.

## Step 1

A simulated Rubik's Cube is generated and all of the corners and edges are removed leaving only the core.

![Dissasembled Rubik's Cube](https://sites.google.com/a/ep-student.org/rubik-s-cube/_/rsrc/1472866160777/rubik-s-cube-core/imgres.jpg?height=192&width=320, "Disassembled Rubik's Cube")

## Step 2

The corner and edge pieces are randomly placed back into the core, resulting in a Rubik's Cube in a random state. This is the state the Rubik's Cube will be in when the generated scramble is applied to a solved Rubik's Cube.

![Reassembled Rubik's Cube](https://static1.squarespace.com/static/54f2df67e4b079e94c291e4f/t/55150c87e4b0392be71ae4c6/1427442824922/scrambled_rubik%27s_cube?format=500w "Reassembled Rubik's Cube")

## Step 3

The [kociemba two-phase solving algorithm](http://kociemba.org/cube.htm) is applied to the randomly assembled Rubik's Cube. The inverse of the solution is the completed scramble.

