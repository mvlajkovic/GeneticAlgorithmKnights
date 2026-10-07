# Genetic Algorithm: Knights on a Chessboard

A Java console application that uses a **genetic algorithm** to place knights on an 8×8 chessboard so that **no two knights attack each other**, and to search for the largest number of knights for which such a placement exists.

## How it works

A candidate solution (an *individual*) is a board, an 8×8 grid of `0` (empty) and `1` (knight). A population of 100 boards evolves for 100 generations:

1. **Fitness**: the algorithm counts how many knights are attacked by other knights. Fitness is `1 / attacks`, and `1.0` means a conflict-free board.
2. **Selection**: roulette-wheel (fitness-proportionate) selection picks two parents.
3. **Crossover**: each cell is taken from one parent or the other, producing two children.
4. **Mutation**: each cell is randomly re-set with probability `0.25`.
5. The new generation replaces the old one, and the best board seen so far is tracked and printed.

### Run modes

On start the program asks `Enter number of knights:`

| Input | Mode | What happens |
| --- | --- | --- |
| A number from `1` to `64` | **Option A** | Searches for a conflict-free board with exactly that many knights and prints every generation's best board and the best overall. Values above 64 are capped at 64. |
| `0`, empty, or anything that isn't a number | **Option C** | Starts at 1 knight and keeps adding one, running a full search each time, until a search fails to find a conflict-free board. Prints the last number that worked, with an example board. |
| (code only) | **Option B** | Variable-size individuals where the number of knights is not fixed. This option is in development. 

Option A keeps the number of knights fixed through crossover and mutation (`ChessBoardA`). Option C is built on option A.

## Project structure

```
GeneticAlgorithmKnights/
├── build.xml, manifest.mf, nbproject/     # NetBeans / Ant project files
├── src/genal/
│   ├── Main.java               # Input handling and run modes (A, B, C)
│   ├── GeneticAlgorithm.java   # Interface: fitness(), crossover(), mutate()
│   ├── ChessBoardA.java        # Individual with a fixed number of knights
│   ├── ChessBoardB.java        # Individual with a variable number of knights
│   ├── Population.java         # Selection, new generation, best-of-population
│   ├── BestMatchA.java         # Best result record for A (board, generation, index)
│   └── BestMatchB.java         # Best result record for B
└── test/genal/ChessBoardATest.java   # JUnit test for the fitness function
```

## Requirements

- Java **11 or newer** (JDK)
- Optional: [Apache NetBeans](https://netbeans.apache.org/) (the repository is a NetBeans project; the unit tests use the JUnit libraries bundled with it)

## Running

**In NetBeans:** open the project and press Run (main class `genal.Main`). To run the tests, use Test Project.

**From the command line** (in the project's root folder):

```bash
javac -d out src/genal/*.java
java -cp out genal.Main
```

Then type a number of knights, for example `8`, or press Enter for option C.

### Example output (option A, 8 knights)

```
GENERATION 0
BEST MATCH
Generation 0 individual 6 {
1 1 0 0 0 0 0 0
0 0 0 0 0 0 1 1
0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0
0 0 0 0 0 1 0 0
0 0 0 0 0 1 0 0
1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
} with fitness: 1.0 and no of knights: 8
```

## Configuration

The parameters are constants at the top of `Main.main`:

| Parameter | Default | Meaning |
| --- | --- | --- |
| `noOfIndividuals` | 100 | Population size (must be even) |
| `noOfGen` | 100 | Number of generations per search |
| `mutationRate` | 0.25 | Chance that a cell is re-randomized |

The board size is fixed at 8 in `ChessBoardA` and `ChessBoardB` (`length = 8`).

## Notes and limitations

- **Results vary between runs.** The algorithm is random. In option C a single run found 14 knights, while the true maximum on an 8×8 board is 32, so option C gives a heuristic lower bound, not the optimum.
- **Option A with more than 32 knights cannot succeed**, because no conflict-free placement exists. It prints the best attempt, and its fitness stays below 1.0.
- **No elitism.** The best board is remembered and printed, but it is not copied into the next generation, so the population can lose a good solution.
- An odd population size fails, because children are created in pairs.
- Only the fitness function has a test.

## Ideas for improvement

- Add elitism and tournament selection
- Finish option B. 
- Make board size, population, generations and mutation rate command-line arguments
- Stop early once a conflict-free board is found
- Add tests for crossover and mutation, for example that the knight count stays constant in option A
