package com.solutions.samples.mvc.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Evgeny Isaev
 */
public class Main {

    final static Set<BigInteger> artifacts = new HashSet<BigInteger>();

    final static String ARTIFACT_TYPE_NAME = "obj_";
    final static String ARTIFACT_FILE_EXT = ".sql";

    final static String ARTIFACT_NC_OBJECT_DELETE_SCRIPT = "/*\n" +
            "/*Encoding isn't defined and will be 'UTF-8'*/\n" +
            "/*\n" +
            "/* CONFIGURATION #%s START */\n" +
            "/* Belongs to: BellAliant */\n" +
            "\n" +
            "delete from NC_OBJECTS t where object_id = %s\n" +
            "/\n" +
            "/*\n" +
            "/* CONFIGURATION #%s END */";

    public static void main(String[] args) throws IOException {
        //if (args.length > 0)
        {
            final String SAMPLE_STREAM_DIR = "d:\\projects\\NC\\Brunches\\BellAliant\\FD1F5\\bellaliant_common\\scripts\\install\\Data\\";

            final String artifactFilePath = SAMPLE_STREAM_DIR + "for_delete.txt";
            //String.valueOf(args[0]);

            final String streamDirectoryPath = SAMPLE_STREAM_DIR;
            //String.valueOf(args[1]);

            final String deleteDirectoryPath = SAMPLE_STREAM_DIR+"configuration\\deleted\\";
            //String.valueOf(args[2]);

            parseArtifacts(artifactFilePath);

            findAndRemoveFiles(new File(streamDirectoryPath));
            
            File deleteDirectory = new File(deleteDirectoryPath);
            for (BigInteger artifactId: artifacts){
                generateScriptForArtifact(deleteDirectory, artifactId);
            }
        }
    }

    private static void parseArtifacts(String artifactFilePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(artifactFilePath));
        while (bufferedReader.ready()){
            final String line = bufferedReader.readLine();
            artifacts.add(new BigInteger(line));
        }
        bufferedReader.close();
    }

    private static void generateScriptForArtifact(File deleteDirectory, BigInteger artifactId) throws IOException {
        String artifactDeleteFilename = ARTIFACT_TYPE_NAME + artifactId.toString() + ARTIFACT_FILE_EXT;
        File deleteArtifactFile = new File(deleteDirectory, artifactDeleteFilename);
        if (!deleteArtifactFile.exists()){
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(deleteArtifactFile));
            bufferedWriter.write(String.format(ARTIFACT_NC_OBJECT_DELETE_SCRIPT, artifactId, artifactId, artifactId));
            bufferedWriter.flush();
            bufferedWriter.close();
        }
    }

    public static void findAndRemoveFiles(File file){
        if (file.isFile()){
            checkAndDelete(file);
        }
        if (file.isDirectory()){
            for (File parentFile: file.listFiles()){
                findAndRemoveFiles(parentFile);
            }
        }
    }

    private static void checkAndDelete(File file) {
        final String fileName = file.getName();
        if (fileName.contains(ARTIFACT_FILE_EXT))
        {
            for (BigInteger artifactId: artifacts){
                if (fileName.contains(artifactId.toString())){
                    final boolean delete = file.delete();
                    if (!delete){
                        System.out.println("delete=false; file="+file);
                    }
                }
            }

        }
    }
}
