/********************************************************************************************
 *   COPYRIGHT (C) 2024 CREVAVI TECHNOLOGIES PVT LTD
 *   The reproduction, transmission or use of this document/file or its
 *   contents is not permitted without written authorization.
 *   Offenders will be liable for damages. All rights reserved.
 *---------------------------------------------------------------------------
 *   Purpose:  MainController.java
 *   Project:  JavaFX Pie Chart Event Handling
 *   Platform: Cross-platform (Windows, macOS, Linux)
 *   Compiler: JDK-22
 *   IDE:      Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)
 *	           Version: 2024-03 (4.31.0)
 *             Build id: 20240307-1437
 ********************************************************************************************/

package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.collections.FXCollections;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.collections.ObservableList;

/**
 * The MainController class is responsible for handling user interactions with
 * the JavaFX PieChart. It initializes the PieChart with data and updates the
 * status label based on user input.
 */
public class MainController {

	@FXML
	private PieChart piechart;

	@FXML
	private Label status;

	/**
	 * This method is called when the user clicks the button. It initializes the
	 * PieChart with predefined data and sets up event handlers for mouse clicks on
	 * the chart slices.
	 * 
	 * @param event the action event triggered by clicking the button
	 */
	public void btn(ActionEvent event) {
		ObservableList<Data> list = FXCollections.observableArrayList(new PieChart.Data("Java", 50),
				                                                      new PieChart.Data("C++", 20),
				                                                      new PieChart.Data("Python", 30),
				                                                      new PieChart.Data("C#", 10),
				                                                      new PieChart.Data("C", 15));
		piechart.setData(list);

		for (final PieChart.Data data : piechart.getData()) {
			data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					status.setText(String.valueOf(data.getPieValue()) + "%");
				}
			});
		}
	}
}
