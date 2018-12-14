## Usage

The package exposes just one function ```solve()```, which accepts a cube definition string and returns a solution string in standard notation (see below).
Optional second argument allows solving to a specific pattern.

```python
>>> import kociemba

>>> kociemba.solve('DRLUUBFBRBLURRLRUBLRDDFDLFUFUFFDBRDUBRUFLLFDDBFLUBLRBD')
u"D2 R' D' F2 B D R2 D2 R' F2 D' F2 U' B2 L2 U2 D R2 U"

>>> kociemba.solve('FLBUULFFLFDURRDBUBUUDDFFBRDDBLRDRFLLRLRULFUDRRBDBBBUFL', 'BBURUDBFUFFFRRFUUFLULUFUDLRRDBBDBDBLUDDFLLRRBRLLLBRDDF')
u"R' D2 R' U2 R F2 D B2 U' R F' U R2 D L2 D' B2 R2 B2 U' B2"
```

## Cube string notation
The names of the facelet positions of the cube (letters stand for Up, Left, Front, Right, Back, and Down):
```
             |************|
             |*U1**U2**U3*|
             |************|
             |*U4**U5**U6*|
             |************|
             |*U7**U8**U9*|
             |************|
 ************|************|************|************
 *L1**L2**L3*|*F1**F2**F3*|*R1**R2**R3*|*B1**B2**B3*
 ************|************|************|************
 *L4**L5**L6*|*F4**F5**F6*|*R4**R5**R6*|*B4**B5**B6*
 ************|************|************|************
 *L7**L8**L9*|*F7**F8**F9*|*R7**R8**R9*|*B7**B8**B9*
 ************|************|************|************
             |************|
             |*D1**D2**D3*|
             |************|
             |*D4**D5**D6*|
             |************|
             |*D7**D8**D9*|
             |************|
```

A cube definition string "UBL..." means that in position U1 we have the U-color, in position U2 we have the
B-color, in position U3 we have the L color etc. according to the order `U1`, `U2`, `U3`, `U4`, `U5`, `U6`, `U7`, `U8`, `U9`, `R1`, `R2`,
`R3`, `R4`, `R5`, `R6`, `R7`, `R8`, `R9`, `F1`, `F2`, `F3`, `F4`, `F5`, `F6`, `F7`, `F8`, `F9`, `D1`, `D2`, `D3`, `D4`, `D5`, `D6`, `D7`, `D8`, `D9`, `L1`, `L2`, `L3`, `L4`,
`L5`, `L6`, `L7`, `L8`, `L9`, `B1`, `B2`, `B3`, `B4`, `B5`, `B6`, `B7`, `B8`, `B9`.

So, for example, a definition of a solved cube would be `UUUUUUUUURRRRRRRRRFFFFFFFFFDDDDDDDDDLLLLLLLLLBBBBBBBBB`

Solution string consists of space-separated parts, each of them represents a single move:
* A single letter by itself means to turn that face clockwise 90 degrees.
* A letter followed by an apostrophe means to turn that face counterclockwise 90 degrees.
* A letter with the number 2 after it means to turn that face 180 degrees.

e.g. **`R U R’ U R U2 R’ U`**

## C version
C sources reside in the `ckociemba` folder. Running `make` inside this directory will compile a standalone binary. It accepts a cube representation as a command line argument, and writes the solution to the standard output. You can, of course, use `ckociemba` sources directly in your projects.

## Performance
When possible, `kociemba` will use C implementation under the hood. If something goes wrong (C version cannot be imported) it will automatically fall back to pure-Python implementation. However, it will be much slower.
