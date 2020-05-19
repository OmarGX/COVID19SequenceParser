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
            FileWriter fw = new FileWriter("output/outputFile.txt");
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

    public void AlignmentDiffOutput(LinkedList<DiffMatchPatch.Diff> list) {

        try {
            FileWriter fw = new FileWriter("outputFile.txt");


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
