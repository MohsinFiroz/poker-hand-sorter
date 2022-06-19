
# Poker Hand Sorter

This is command line program that takes, via STDIN, a "stream" of hands for a two player poker game. At the completion of the stream, it prints to STDOUT the number of hands won by Player 1, and the number of hands won by Player 2.

**Note: Validation was not handled since it was assumed that this application would always get valid STDIN.**


## 📖 Instructions

Instructions to make jar in Eclipse :

> Right click on your Java Project and select Export.

> Select Java -> Runnable JAR file -> Next.

> Select the Launch Configuration and choose **GameMain.java** file as your Main class

> Select the Destination folder where you would like to save it and click Finish.


***Note: Latest jar file and text input file were added on the root folder as well for your convenience.***

## ⚡️ Run

On Windows

```bash
  type poker-hands.txt | java -jar my-poker-solution.jar
```

On Linux

```bash
  cat poker-hands.txt | java -jar my-poker-solution.jar
```
