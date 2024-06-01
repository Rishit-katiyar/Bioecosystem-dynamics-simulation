import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.chart.{LineChart, NumberAxis, XYChart}
import scalafx.collections.ObservableBuffer

object Visualization extends JFXApp {
  val timeAxis = new NumberAxis()
  val populationAxis = new NumberAxis()
  val lineChart = new LineChart[Number, Number](timeAxis, populationAxis)

  stage = new JFXApp.PrimaryStage {
    title = "Ecosystem Dynamics Simulation"
    scene = new Scene {
      root = lineChart
    }
  }

  def addSeriesToChart(seriesName: String, data: Seq[(Double, Double)]): Unit = {
    val series = new XYChart.Series[Number, Number] {
      name = seriesName
      data = ObservableBuffer(data.map { case (x, y) => XYChart.Data[Number, Number](x, y) })
    }
    lineChart.getData.add(series)
  }
}
