# ARXML_Reorder
Exception Handling Assignment
Write a program that reads an ARXML file containing a list of containers, each with a unique ID, and
reorders the containers alphabetically by their name sub- container “"SHORT-NAME"
”. The program should write the reordered containers to a new ARXML file.
ARXML stands for Autosar xml
Autosar stands for AUTomotive Open System ARchitecture
Delivery:
1- Link to a git-hub repository including your implementation.
2- Readme.md file must exist with proper documentation.
3- Batch file which invoke the three possible cases:
• Normal case --> provide the input file and specify it’s name inside the batch script.
• Not valid Autosar file case --> provide the file also
• Empty file
• The goal is that I’m able to run the batch file to test all cases.
• Include compilation of the java file at the beginning.
Requirements:
1- The name of the arxml file shall be an argument which needs to passed through the command
line.
2- If the file is not having .arxml extension then you should trigger a user defined checked
exception “NotVaildAutosarFileException”.
3- If the file is empty, then you should trigger user defined unchecked exception
“EmptyAutosarFileException”
4- The output file shall be named as the same of the input file concatenated with “_mod.arxml”
• e.g. if the input was named “Rte_Ecuc.arxml” then the output should be
“Rte_Ecuc_mod.arxml”.
5- Assume any missing requirement.

Sample input file:
<?xml version="1.0" encoding="UTF-8"?>
<AUTOSAR>
 <CONTAINER UUID="198ae269-8478-44bd-92b5-14982c4ff68a">
 <SHORT-NAME>ContainerB</SHORT-NAME>
 <LONG-NAME>AA</LONG-NAME>
 </CONTAINER>
 <CONTAINER UUID="198ae269-8478-44bd-92b5-14982c4ff68b">
 <SHORT-NAME>ContainerA</SHORT-NAME>
 <LONG-NAME>BB</LONG-NAME>
 </CONTAINER>
 <CONTAINER UUID="198ae269-8478-44bd-92b5-14982c4ff68c">
 <SHORT-NAME>ContainerC</SHORT-NAME>
 <LONG-NAME>CC</LONG-NAME>
 </CONTAINER>
</AUTOSAR>

Output should be:
<?xml version="1.0" encoding="UTF-8"?>
<AUTOSAR>
 <CONTAINER UUID="198ae269-8478-44bd-92b5-14982c4ff68b">
 <SHORT-NAME>ContainerA</SHORT-NAME>
 <LONG-NAME>BB</LONG-NAME>
 </CONTAINER>
 <CONTAINER UUID="198ae269-8478-44bd-92b5-14982c4ff68a">
 <SHORT-NAME>ContainerB</SHORT-NAME>
 <LONG-NAME>AA</LONG-NAME>
 </CONTAINER>
 <CONTAINER UUID="198ae269-8478-44bd-92b5-14982c4ff68c">
 <SHORT-NAME>ContainerC</SHORT-NAME>
 <LONG-NAME>CC</LONG-NAME>
 </CONTAINER>
</AUTOSAR>
