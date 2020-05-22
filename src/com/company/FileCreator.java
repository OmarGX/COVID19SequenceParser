package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class FileCreator {
    public FileCreator() {}
    /*
    Methods that generate output file
    The output file present an header identified by line marked with #, and it
    contains the basic information about the sequences. this part is created in the generateFileHeader()
    method

    For every Sequence, a new block identified with @ is presented. in those blocks, we report the
    various differences that occurs between RefSeq and other strings in the analysis. This part is made in
    the AlignmentDiffOutput() method.
    */
    public void generateHeaderFile(String[] sequences) {
        try {
            File outputFile = new File("output\\outputFile.txt");
            if (outputFile.createNewFile()) {
                System.out.println("File created: " + outputFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        try {
            FileWriter fw = new FileWriter("output\\outputFile.txt");
            for(String seq : sequences) {
                if(seq.contains("NC_045512")){
                    fw.write("#RefSeq: "+seq.split("\n", 2)[0]+"\n");
                }
            }
            for (String seq :sequences) {
                if(!seq.contains("NC_045512") && !seq.equals("")){
                    fw.write("#"+seq.split("\n", 2)[0]+"\n");
                }
            }
            fw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AlignmentDiffOutput(LinkedList<DiffMatchPatch.Diff> list, String actualstringId) {
        try {
            FileWriter fw = new FileWriter("output\\outputFile.txt", true);
            fw.write("@"+actualstringId+"\n");
            for(DiffMatchPatch.Diff diff : list) {
                if(diff.getStartIndex()>=266 && diff.getStartIndex()<=21555) {
                    fw.write("(" + diff.getOperation() + ":" + diff.getText() + ")/[" + (diff.getStartIndex() + 1) + "]:ORF1ab\n");
                }
                else if(diff.getStartIndex()>=27893 && diff.getStartIndex()<28259){
                    fw.write("(" + diff.getOperation() + ":" + diff.getText() + ")/[" + (diff.getStartIndex() + 1) + "]:ORF8\n");
                }
                else if(diff.getStartIndex()>=29557 && diff.getStartIndex()<29674){
                    fw.write("(" + diff.getOperation() + ":" + diff.getText() + ")/[" + (diff.getStartIndex() + 1) + "]:ORF10\n");
                }
                else if(diff.getStartIndex()>=28273 && diff.getStartIndex()<29553){
                    fw.write("(" + diff.getOperation() + ":" + diff.getText() + ")/[" + (diff.getStartIndex() + 1) + "]:N\n");
                }
                else if(diff.getStartIndex()>=27755 && diff.getStartIndex()<27887){
                    fw.write("(" + diff.getOperation() + ":" + diff.getText() + ")/[" + (diff.getStartIndex() + 1) + "]:ORF7b\n");
                }
                else if(diff.getStartIndex()>=27393 && diff.getStartIndex()<27755){
                    fw.write("(" + diff.getOperation() + ":" + diff.getText() + ")/[" + (diff.getStartIndex() + 1) + "]:ORF7a\n");
                }
                else if(diff.getStartIndex()>=27201 && diff.getStartIndex()<=27387){
                    fw.write("(" + diff.getOperation() + ":" + diff.getText() + ")/[" + (diff.getStartIndex() + 1) + "]:ORF6\n");
                }
                else if(diff.getStartIndex()>=26522 && diff.getStartIndex()<=27191){
                    fw.write("(" + diff.getOperation() + ":" + diff.getText() + ")/[" + (diff.getStartIndex() + 1) + "]:M\n");
                }
                else if(diff.getStartIndex()>=26244 && diff.getStartIndex()<=26472){
                    fw.write("(" + diff.getOperation() + ":" + diff.getText() + ")/[" + (diff.getStartIndex() + 1) + "]:E\n");
                }
                else if(diff.getStartIndex()>=25392 && diff.getStartIndex()<=26220){
                    fw.write("(" + diff.getOperation() + ":" + diff.getText() + ")/[" + (diff.getStartIndex() + 1) + "]:ORF3a\n");
                }
                else if(diff.getStartIndex()>=21562 && diff.getStartIndex()<=25384){
                    fw.write("(" + diff.getOperation() + ":" + diff.getText() + ")/[" + (diff.getStartIndex() + 1) + "]:S\n");
                }
                else {
                    fw.write("(" + diff.getOperation() + ":" + diff.getText() + ")/[" + (diff.getStartIndex() + 1) + "]:NONE\n");
                }

            }
            fw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
