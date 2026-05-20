package L8.Unweighted;

import java.util.ArrayList;

public class Graph<T extends Comparable<T>> {
    Vertex<T> head;
    int size;

    public Graph() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean hasVertex(T v) {
        if(head == null) {
            return false;
        }
        Vertex<T> temp = head;
        while(temp != null) {
            if(temp.vertexInfo.compareTo(v) == 0) {
                return true;
            }
            temp = temp.nextVertex;
        }
        return false;
    }

    public int getIndeg(T v) {
        if(hasVertex(v) == true) {
            Vertex<T> temp = head;
            while(temp != null) {
                if(temp.vertexInfo.compareTo(v) == 0) {
                    return temp.indeg;
                }
                temp = temp.nextVertex;
            }
        }
        return -1;
    }

    public int getOutdeg(T v) {
        if(hasVertex(v) == true) {
            Vertex<T> temp = head;
            while(temp != null) {
                if(temp.vertexInfo.compareTo(v) == 0) {
                    return temp.outdeg;
                }
                temp = temp.nextVertex;
            }
        }
        return -1;
    }

    public boolean addVertex(T v) {
        if(hasVertex(v) == false) {
            Vertex<T> temp = head;
            Vertex<T> newVertex = new Vertex<>(v, null);
            if(head == null) {
                head = newVertex;
            } else {
                Vertex<T> previous = head;
                while(temp != null) {
                    previous = temp;
                    temp = temp.nextVertex;
                }
                previous.nextVertex = newVertex;
            }
            size++;
            return true;
        } else {
            return false;
        }
    }

    public int getIndex(T v) {
        Vertex<T> temp = head;
        int position = 0;
        while(temp != null) {
            if(temp.vertexInfo.compareTo(v) == 0) {
                return position;
            }
            temp = temp.nextVertex;
            position += 1;        
        }
        return -1;
    }

    public ArrayList<T> getAllVertexObjects() {
        ArrayList<T> list = new ArrayList<>();
        Vertex<T> temp = head;
        while(temp != null) {
            list.add(temp.vertexInfo);
            temp = temp.nextVertex;
        }
        return list;
    }

    public T getVertex(int pos) {
        if(pos > size - 1 || pos < 0) {
            return null;
        }
        Vertex<T> temp = head;
        for(int i = 0; i < pos; i++) {
            temp = temp.nextVertex;
        }
        return temp.vertexInfo;
    }

    public boolean hasEdge(T source, T destination) {
        if(head == null) {
            return false;
        }
        if(!hasVertex(source) || !hasVertex(destination)) {
            return false;
        }
        Vertex<T> sourcVertex = head;
        while(sourcVertex != null) {
            if(sourcVertex.vertexInfo.compareTo(source) == 0) {
                // Reached source vertex
                Edge<T> currentEdge = sourcVertex.firstEdge;
                while(currentEdge != null) {
                    if(currentEdge.toVertex.vertexInfo.compareTo(destination) == 0) {
                        // Destination vertex found
                        return true;
                    }
                    currentEdge = currentEdge.nextEdge;
                }
            }
            sourcVertex = sourcVertex.nextVertex;
        }
        return false;
    }

    public boolean addEdge(T source, T destination) {
        if(head == null) {
            return false;
        }
        if(!hasVertex(source) || !hasVertex(destination)) {
            return false;
        }
        Vertex<T> sourcVertex = head;
        while(sourcVertex != null) {
            if(sourcVertex.vertexInfo.compareTo(source) == 0) {
                // Reached source vertex
                Vertex<T> destinationVertex = head;
                while(destinationVertex != null) {
                    if(destinationVertex.vertexInfo.compareTo(destination) == 0) {
                        // Reached destination vertex
                        Edge<T> currentEdge = sourcVertex.firstEdge;
                        Edge<T> newEdge = new Edge<>(destinationVertex, currentEdge);
                        sourcVertex.firstEdge = newEdge;
                        sourcVertex.outdeg ++;
                        destinationVertex.indeg ++;
                        return true;
                    }
                    destinationVertex = destinationVertex.nextVertex;
                }
            }
            sourcVertex = sourcVertex.nextVertex;
        }
        return false;
    }

    public ArrayList<T> getNeighbours(T v) {
        if(!hasVertex(v)) {
            return null;
        }
        ArrayList<T> list = new ArrayList<>();
        Vertex<T> temp = head;
        while(temp != null) {
            if(temp.vertexInfo.compareTo(v) == 0) {
                // Reached vertex
                Edge<T> currentEdge = temp.firstEdge;
                while(currentEdge != null) {
                    list.add(currentEdge.toVertex.vertexInfo);
                    currentEdge = currentEdge.nextEdge;
                }
            }
            temp = temp.nextVertex;
        }
        return list;
    }

    public void printEdges() {
        Vertex<T> temp = head;
        while(temp != null) {
            System.out.print("# " + temp.vertexInfo + " : ");
            Edge<T> currentEdge = temp.firstEdge;
            while(currentEdge != null) {
                System.out.print("[" + temp.vertexInfo + ", " + 
                    currentEdge.toVertex.vertexInfo + "]"
                );
                currentEdge = currentEdge.nextEdge;
            }
            System.out.println();
            temp = temp.nextVertex;
        }
    }


    // ============================================
    // Q3
    // ============================================
    public boolean addUndirectedEdge(T source, T destination) {
        boolean path1 = addEdge(source, destination);
        boolean path2 = addEdge(destination, source);

        return path1 && path2;
    }

}
