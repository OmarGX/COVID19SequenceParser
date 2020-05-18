package com.company;

import java.nio.file.Files;
import java.util.ArrayList;
import java.io.*;
import java.util.LinkedList;
import com.company.DiffMatchPatch;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws IOException {
        DiffMatchPatch dmp = new DiffMatchPatch();
        String fileContent = "";
        String refSeq = "";
        ArrayList<String> aligned_Seq = new ArrayList<String>();
        File newFile = new File("C:\\Users\\omarg\\Documents\\Bioinformatica\\Progetto\\MAFFT\\MAFFT-fasta.txt");
        if (newFile.isFile()) {
            try {
                fileContent = Files.readString(newFile.toPath());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
        String[] sequences = fileContent.split(">");
        for (String seq : sequences) {
            aligned_Seq.add(seq);
        }
        for (String seq : aligned_Seq) {
            if (seq.contains("NC_045512")) {
                refSeq = seq.split("\n", 2)[1];
            }
        }
        for (int i = 2; i < aligned_Seq.size(); i++) {
            String actualString = aligned_Seq.get(i).split("\n", 2)[1].replace("\n", "");
            String actualStringId = aligned_Seq.get(i).split("\n", 2)[0].split("\\|")[0];
            System.out.println("\n"+actualStringId);
            LinkedList<DiffMatchPatch.Diff> diffs = dmp.diff_main(refSeq.replace("\n", ""), actualString);
            Iterator<DiffMatchPatch.Diff> iterList = diffs.iterator();
            while (iterList.hasNext()) {
                DiffMatchPatch.Diff item = iterList.next();
                if (item.getOperation() == DiffMatchPatch.Operation.EQUAL) {
                    iterList.remove();
                }
            }
            for (DiffMatchPatch.Diff d : diffs) {
                System.out.print(d + "->");
                System.out.println("[" + d.getStartIndex() + "]");
            }
        }
    }
}
