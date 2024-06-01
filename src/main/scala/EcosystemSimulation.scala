import Models._
import Visualization._

object EcosystemSimulation extends App {
  val prey = Species("Prey", 100, 0.1, predationRate = Some(0.01))
  val predator = Species("Predator", 10, 0.1, predationRate = Some(0.01))

  val speciesA = Species("SpeciesA", 50, 0.2, carryingCapacity = Some(200))
  val speciesB = Species("SpeciesB", 50, 0.2, carryingCapacity = Some(200))

  val mutualisticSpeciesA = Species("MutualisticA", 30, 0.1, mutualisticBenefit = Some(0.05), mutualisticCost = Some(0.01))
  val mutualisticSpeciesB = Species("MutualisticB", 30, 0.1, mutualisticBenefit = Some(0.05), mutualisticCost = Some(0.01))

  val environment = Environment(100, "summer")

  val timeSteps = 500
  val timeStepSize = 1.0

  var preyPopulationData = Seq[(Double, Double)]()
  var predatorPopulationData = Seq[(Double, Double)]()
  var speciesAPopulationData = Seq[(Double, Double)]()
  var speciesBPopulationData = Seq[(Double, Double)]()
  var mutualisticAPopulationData = Seq[(Double, Double)]()
  var mutualisticBPopulationData = Seq[(Double, Double)]()

  for (t <- 0 to timeSteps) {
    val (updatedPrey, updatedPredator) = lotkaVolterra(prey, predator, timeStepSize)
    preyPopulationData :+= (t * timeStepSize, updatedPrey.population)
    predatorPopulationData :+= (t * timeStepSize, updatedPredator.population)

    val (updatedSpeciesA, updatedSpeciesB) = competition(speciesA, speciesB, 0.1, timeStepSize)
    speciesAPopulationData :+= (t * timeStepSize, updatedSpeciesA.population)
    speciesBPopulationData :+= (t * timeStepSize, updatedSpeciesB.population)

    val (updatedMutualisticA, updatedMutualisticB) = mutualism(mutualisticSpeciesA, mutualisticSpeciesB, timeStepSize)
    mutualisticAPopulationData :+= (t * timeStepSize, updatedMutualisticA.population)
    mutualisticBPopulationData :+= (t * timeStepSize, updatedMutualisticB.population)

    val updatedEnvironment = updateEnvironment(environment, timeStepSize)
  }

  addSeriesToChart("Prey", preyPopulationData)
  addSeriesToChart("Predator", predatorPopulationData)
  addSeriesToChart("SpeciesA", speciesAPopulationData)
  addSeriesToChart("SpeciesB", speciesBPopulationData)
  addSeriesToChart("MutualisticA", mutualisticAPopulationData)
  addSeriesToChart("MutualisticB", mutualisticBPopulationData)
}
