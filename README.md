# 🌿 Ecosystem Dynamics Simulation

Welcome to the **Ecosystem Dynamics Simulation** project! This project is a Scala-based simulation of ecosystem dynamics, including predator-prey interactions, competition, and symbiosis, with graphical visualization. 🦁🐰🌳

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Ecosystem Dynamics Workings](#ecosystem-dynamics-workings)
  - [Predator-Prey Dynamics](#predator-prey-dynamics)
  - [Competition](#competition)
  - [Mutualism](#mutualism)
  - [Environment Dynamics](#environment-dynamics)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The Ecosystem Dynamics Simulation project aims to provide a comprehensive and interactive way to study the complex interactions within an ecosystem. By simulating predator-prey dynamics, competition, and mutualism, this project offers valuable insights into ecological processes. 

## Features

✨ **Predator-Prey Dynamics**: Simulate interactions between predators and their prey using the Lotka-Volterra model.

✨ **Competition**: Model competition between species for resources with a carrying capacity.

✨ **Mutualism**: Explore symbiotic relationships where species benefit from each other.

✨ **Environment Dynamics**: Observe how environmental factors such as resources and climate change over time.

✨ **Visualization**: Real-time graphical representation of population changes.

## Installation

Follow these steps to set up the project locally on your machine:

### Prerequisites

- Ensure you have [Scala](https://www.scala-lang.org/download/) installed. You can install it via [sdkman](https://sdkman.io/).

  ```sh
  sdk install scala
  ```

- Ensure you have [SBT (Scala Build Tool)](https://www.scala-sbt.org/download.html) installed.

  ```sh
  sdk install sbt
  ```

- Install Java (JDK 8 or later).

### Clone the Repository

```sh
git clone https://github.com/Rishit-katiyar/ecosystem-dynamics-simulation.git
cd ecosystem-dynamics-simulation
```

### Build the Project

Compile the project using SBT:

```sh
sbt compile
```

### Run the Simulation

Run the simulation to see the ecosystem dynamics in action:

```sh
sbt run
```

### Run the Tests

Run the tests to ensure everything is working correctly:

```sh
sbt test
```

## Usage

Once you have the project set up and running, you can observe the population dynamics of different species over time through the graphical interface provided by ScalaFX. The simulation includes:

- **Predator-Prey Interactions**: Observe how predator and prey populations influence each other.
- **Competition**: See how species compete for resources.
- **Mutualism**: Explore the benefits of mutualistic relationships.

Feel free to tweak the parameters in the `EcosystemSimulation.scala` file to see how different factors affect the ecosystem!

## Project Structure

Here's an overview of the project structure:

```
ecosystem-dynamics-simulation/
├── LICENSE
├── .gitignore
├── README.md
├── build.sbt
├── src/
│   └── main/
│       └── scala/
│           ├── EcosystemSimulation.scala
│           ├── Models.scala
│           └── Visualization.scala
└── src/
    └── test/
        └── scala/
            └── EcosystemSimulationTest.scala
```

- **EcosystemSimulation.scala**: Contains the main logic for running the simulation.
- **Models.scala**: Defines the data structures and methods for different ecological models.
- **Visualization.scala**: Sets up the graphical visualization using ScalaFX.
- **EcosystemSimulationTest.scala**: Contains unit tests for the different models.

## Ecosystem Dynamics Workings

### Predator-Prey Dynamics

The predator-prey dynamics are modeled using the Lotka-Volterra equations. This model describes how the population sizes of two species (predators and prey) interact over time. The equations are:

- Prey population change: `dPrey/dt = α * Prey - β * Prey * Predator`
- Predator population change: `dPredator/dt = δ * Prey * Predator - γ * Predator`

Where:
- `α` is the natural growth rate of prey in the absence of predators.
- `β` is the predation rate coefficient.
- `δ` is the reproduction rate of predators per prey eaten.
- `γ` is the natural death rate of predators in the absence of prey.

This model helps simulate the oscillatory nature of predator-prey relationships.

### Competition

In this model, we simulate competition between two species for the same resources. The competition is modeled using the Lotka-Volterra competition equations:

- Species A population change: `dA/dt = rA * A * (1 - (A + αB) / KA)`
- Species B population change: `dB/dt = rB * B * (1 - (B + βA) / KB)`

Where:
- `rA` and `rB` are the intrinsic growth rates of species A and B.
- `KA` and `KB` are the carrying capacities of species A and B.
- `α` and `β` are competition coefficients.

This model captures how species A and B compete for limited resources, affecting their growth rates and population sizes.

### Mutualism

Mutualism models the interaction where two species benefit from each other. The equations used are:

- Species A population change: `dA/dt = rA * A + cA * A * B`
- Species B population change: `dB/dt = rB * B + cB * A * B`

Where:
- `rA` and `rB` are the growth rates of species A and B in the absence of mutualistic interactions.
- `cA` and `cB` are the mutualistic interaction coefficients.

This model shows how mutualistic relationships can enhance the growth rates of both species involved.

### Environment Dynamics

The environment in this simulation includes resources and climate, which can affect the populations. The environment dynamics are simplified:

- Resources change over time based on a sinusoidal function to simulate seasonal changes.
- Climate alternates between "summer" and "winter" based on the time step, simulating seasonal changes.

These environmental factors can influence the growth rates and interactions of species within the ecosystem.

## Contributing

Contributions are welcome! If you'd like to contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add some feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Open a pull request.

Please make sure to update tests as appropriate.

## License

This project is licensed under the GNU General Public License v3.0. See the [LICENSE](LICENSE) file for details.

## Happy coding! 😊🌱
