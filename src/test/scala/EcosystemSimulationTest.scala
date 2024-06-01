import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import Models._

class EcosystemSimulationTest extends AnyFlatSpec with Matchers {

  "Lotka-Volterra model" should "correctly update predator and prey populations" in {
    val prey = Species("Prey", 100, 0.1, predationRate = Some(0.01))
    val predator = Species("Predator", 10, 0.1, predationRate = Some(0.01))
    val (updatedPrey, updatedPredator) = lotkaVolterra(prey, predator, 1.0)

    updatedPrey.population should be > prey.population
    updatedPredator.population should be > predator.population
  }

  "Competition model" should "correctly update competing species populations" in {
    val speciesA = Species("SpeciesA", 50, 0.2, carryingCapacity = Some(200))
    val speciesB = Species("SpeciesB", 50, 0.2, carryingCapacity = Some(200))
    val (updatedSpeciesA, updatedSpeciesB) = competition(speciesA, speciesB, 0.1, 1.0)

    updatedSpeciesA.population should be > speciesA.population
    updatedSpeciesB.population should be > speciesB.population
  }

  "Mutualism model" should "correctly update mutualistic species populations" in {
    val speciesA = Species("MutualisticA", 30, 0.1, mutualisticBenefit = Some(0.05), mutualisticCost = Some(0.01))
    val speciesB = Species("MutualisticB", 30, 0.1, mutualisticBenefit = Some(0.05), mutualisticCost = Some(0.01))
    val (updatedSpeciesA, updatedSpeciesB) = mutualism(speciesA, speciesB, 1.0)

    updatedSpeciesA.population should be > speciesA.population
    updatedSpeciesB.population should be > speciesB.population
  }

  "Environment model" should "correctly update environmental factors" in {
    val environment = Environment(100, "summer")
    val updatedEnvironment = updateEnvironment(environment, 1.0)

    updatedEnvironment.resources should not be environment.resources
    updatedEnvironment.climate shouldBe "summer" // assuming the time step doesn't change the season in this test case
  }
}
