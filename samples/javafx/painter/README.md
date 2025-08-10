1. Download JavaFX SDK from https://gluonhq.com/products/javafx/

2. Unzip the JavaFX SDK to a directory of your choice. e.g. C:\JavaFXSDK, ~/code/javafx-sdk-24.0.2 (On Mac or Linux)

3. Compile the code in this folder using the following command:
On Windows:
javac --module-path C:\JavaFXSDK\lib --add-modules javafx.fxml,javafx.base,javafx.controls *.java

On Mac or Linux:
javac --module-path ~/code/javafx-sdk-24.0.2/lib --add-modules javafx.fxml,javafx.base,javafx.controls *.java

4. Run the Painter app using the following command in a terminal:
On Windows:
java --module-path C:\JavaFXSDK\lib --add-modules javafx.base,javafx.controls,javafx.fxml Painter

On Mac or Linux:
java --module-path ~/code/javafx-sdk-24.0.2/lib --add-modules javafx.base,javafx.controls,javafx.fxml Painter
