import java.util.*;


class Graph {
    private Map<Integer, List<Integer>> emplacementList;

    public Graph() {
        emplacementList = new HashMap<>();
    }

    
    public void addBranche(int source, int destination) {
        emplacementList.putIfAbsent(source, new ArrayList<>());
        emplacementList.putIfAbsent(destination, new ArrayList<>());
        emplacementList.get(source).add(destination);
        emplacementList.get(destination).add(source);
    }

    
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.offer(start);
        

        System.out.print("BFS: ");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : emplacementList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }

    
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS: ");
        dfsRecc(start, visited);
        System.out.println();
    }

    private void dfsRecc(int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");

        for (int neighbor : emplacementList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsRecc(neighbor, visited);
            }
        }
    }

   
    public List<Integer> findShortestPath(int start, int end) {
        Map<Integer, Integer> parentMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        boolean found = false;

        while (!queue.isEmpty() && !found) {
            int node = queue.poll();

            for (int neighbor : emplacementList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, node);
                    queue.offer(neighbor);
                    if (neighbor == end) {
                        found = true;
                        break;
                    }
                }
            }
        }

        List<Integer> courtChemin = new ArrayList<>();
        if (found) {
            for (Integer at = end; at != null; at = parentMap.get(at)) {
                courtChemin.add(at);
            }
            Collections.reverse(courtChemin); 
        }
        return courtChemin;
    }
}



public class CityMap {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addBranche(1, 2);
        graph.addBranche(1, 3);
        graph.addBranche(2, 4);
        graph.addBranche(2, 5);
        graph.addBranche(3, 6);
        graph.addBranche(4, 7);
        graph.addBranche(5, 7);
        graph.addBranche(5, 8);
        graph.addBranche(6, 9);
        graph.addBranche(7, 9);
        graph.addBranche(8, 9);

        System.out.println(graph.toString());
       
        graph.bfs(1);
        graph.dfs(1);

        
        int start = 1;
        int end = 9;
        List<Integer> courtChemin = graph.findShortestPath(start, end);
        if (!courtChemin.isEmpty()) {
            System.out.println("Le chemin le plus court de " + start + " à " + end + ": " + courtChemin);
        } else {
            System.out.println("Aucun chemin trouvé de " + start + " à " + end);
        }
    }
}