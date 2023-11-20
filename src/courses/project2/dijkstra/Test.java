package courses.project2.dijkstra;

import courses.project2.FileNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        int[][] graph ;
        String folderPath = "/Users/wys/Desktop/2591Algo/Project2/Project2_Input_File";

        File folder = new File(folderPath);

        // 检查文件夹是否存在
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()&&file.getName().contains("_File4")) {
                        // 在这里处理每个文件
                        System.out.println("File Name: " + file.getName());
                        try (BufferedReader br = new BufferedReader(new FileReader(file)) ) {
                            String line;
                            int lines = 0;
                            List<FileNode> nodes = new ArrayList<>();
                            while ((line = br.readLine()) != null) {
                                if (lines > 0) {
                                    // 使用逗号分隔符将每一行分割为字段
                                    String[] fields = line.split(",");
                                    FileNode node  = new FileNode();
                                    node.nodeId = Integer.valueOf(fields[0]);
                                    node.connectedNodeID = Integer.valueOf(fields[1]);
                                    node.distance = Integer.valueOf(fields[2]);
                                    node.coordinates = fields[3];
                                    node.intersectionName = fields[4];
                                    nodes.add(node);

                                }
                                lines++;
                            }
                            int maxNode = nodes.stream().max((s1,s2)->Integer.compare(s1.nodeId,s2.nodeId)).get().nodeId;


                            DijkstraMatrixGraph matrixGraph = new DijkstraMatrixGraph(maxNode+1);

                            for (FileNode node : nodes){
                                matrixGraph.addEdge(node.nodeId,node.connectedNodeID,node.distance);
                            }

                            int source = 192;
                            int destination = 163;

                            matrixGraph.dijkstra(source,destination);
                            System.out.println(file.getName()+"---end");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }
}
