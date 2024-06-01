case class Species(
    name: String,
    population: Double,
    growthRate: Double,
    predationRate: Option[Double] = None,
    carryingCapacity: Option[Double] = None,
    mutualisticBenefit: Option[Double] = None,
    mutualisticCost: Option[Double] = None
)

case class Environment(resources: Double, climate: String)

object Models {

  def lotkaVolterra(prey: Species, predator: Species, timeStep: Double): (Species, Species) = {
    val preyPopulationChange = prey.growthRate * prey.population - prey.predationRate.get * prey.population * predator.population
    val predatorPopulationChange = -predator.growthRate * predator.population + predator.predationRate.get * prey.population * predator.population

    val newPreyPopulation = prey.population + preyPopulationChange * timeStep
    val newPredatorPopulation = predator.population + predatorPopulationChange * timeStep

    (prey.copy(population = newPreyPopulation), predator.copy(population = newPredatorPopulation))
  }

  def competition(speciesA: Species, speciesB: Species, competitionCoefficient: Double, timeStep: Double): (Species, Species) = {
    val speciesAPopulationChange = speciesA.growthRate * speciesA.population * (1 - (speciesA.population + competitionCoefficient * speciesB.population) / speciesA.carryingCapacity.get)
    val speciesBPopulationChange = speciesB.growthRate * speciesB.population * (1 - (speciesB.population + competitionCoefficient * speciesA.population) / speciesB.carryingCapacity.get)

    val newSpeciesAPopulation = speciesA.population + speciesAPopulationChange * timeStep
    val newSpeciesBPopulation = speciesB.population + speciesBPopulationChange * timeStep

    (speciesA.copy(population = newSpeciesAPopulation), speciesB.copy(population = newSpeciesBPopulation))
  }

  def mutualism(speciesA: Species, speciesB: Species, timeStep: Double): (Species, Species) = {
    val speciesAPopulationChange = speciesA.mutualisticBenefit.get * speciesA.population * speciesB.population - speciesA.mutualisticCost.get * speciesA.population
    val speciesBPopulationChange = speciesB.mutualisticBenefit.get * speciesB.population * speciesA.population - speciesB.mutualisticCost.get * speciesB.population

    val newSpeciesAPopulation = speciesA.population + speciesAPopulationChange * timeStep
    val newSpeciesBPopulation = speciesB.population + speciesBPopulationChange * timeStep

    (speciesA.copy(population = newSpeciesAPopulation), speciesB.copy(population = newSpeciesBPopulation))
  }

  def updateEnvironment(environment: Environment, timeStep: Double): Environment = {
    val newResources = environment.resources + (math.sin(timeStep) * 10)
    val newClimate = if (timeStep % 365 < 180) "summer" else "winter"
    Environment(newResources, newClimate)
  }
}
