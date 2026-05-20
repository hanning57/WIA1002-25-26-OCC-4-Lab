package L8.Weighted;

import java.util.ArrayList;

public class WeightedGraph<T extends Comparable<T>, N extends Comparable<N>> {
    Vertex<T,N> head;
    int size;

    public WeightedGraph() {
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
        Vertex<T,N> temp = head;
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
            Vertex<T,N> temp = head;
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
            Vertex<T,N> temp = head;
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
            Vertex<T,N> temp = head;
            Vertex<T,N> newVertex = new Vertex<>(v, null);
            if(head == null) {
                head = newVertex;
            } else {
                Vertex<T,N> previous = head;
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
        Vertex<T,N> temp = head;
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
        Vertex<T,N> temp = head;
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
        Vertex<T,N> temp = head;
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
        Vertex<T,N> sourcVertex = head;
        while(sourcVertex != null) {
            if(sourcVertex.vertexInfo.compareTo(source) == 0) {
                // Reached source vertex
                Edge<T,N> currentEdge = sourcVertex.firstEdge;
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

    public boolean addEdge(T source, T destination, N w) {
        if(head == null) {
            return false;
        }
        if(!hasVertex(source) || !hasVertex(destination)) {
            return false;
        }
        Vertex<T,N> sourcVertex = head;
        while(sourcVertex != null) {
            if(sourcVertex.vertexInfo.compareTo(source) == 0) {
                // Reached source vertex
                Vertex<T,N> destinationVertex = head;
                while(destinationVertex != null) {
                    if(destinationVertex.vertexInfo.compareTo(destination) == 0) {
                        // Reached destination vertex
                        Edge<T,N> currentEdge = sourcVertex.firstEdge;
                        Edge<T,N> newEdge = new Edge<>(destinationVertex, w, currentEdge);
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

    public N getEdgeWeight(T source, T destination) {
        N notFound = null;
        if(head == null) {
            return notFound;
        }
        if(!hasVertex(source) || !hasVertex(destination)) {
            return notFound;
        }
        Vertex<T,N> sourcVertex = head;
        while(sourcVertex != null) {
            if(sourcVertex.vertexInfo.compareTo(source) == 0) {
                // Reached source vertex
                Edge<T,N> currentEdge = sourcVertex.firstEdge;
                while(currentEdge != null) {
                    if(currentEdge.toVertex.vertexInfo.compareTo(destination) == 0) {
                        // Destination vertex found
                        return currentEdge.weight;
                    }
                    currentEdge = currentEdge.nextEdge;
                }
            }
            sourcVertex = sourcVertex.nextVertex;
        }
        return notFound;
    }

    public ArrayList<T> getNeighbours(T v) {
        if(!hasVertex(v)) {
            return null;
        }
        ArrayList<T> list = new ArrayList<>();
        Vertex<T,N> temp = head;
        while(temp != null) {
            if(temp.vertexInfo.compareTo(v) == 0) {
                // Reached vertex
                Edge<T,N> currentEdge = temp.firstEdge;
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
        Vertex<T,N> temp = head;
        while(temp != null) {
            System.out.print("# " + temp.vertexInfo + " : ");
            Edge<T,N> currentEdge = temp.firstEdge;
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
    // Q1
    // ============================================
    public boolean addUndirectedEdge(T source, T destination, N w) {
        // Forward path
        boolean path1 = addEdge(source, destination, w);
        boolean path2 = addEdge(destination, source, w);

        if(path1 == true && path2 == true) {
            return true;
        }
        return false;
        // return path1 && path2;
    }


    // ============================================
    // Q2
    // ============================================
    public boolean removeEdge(T source, T destination) {
        if(head == null) {
            return false;
        }
        if(!hasVertex(source) || !hasVertex(destination)) {
            return false;
        }
        Vertex<T,N> sourceVertex = head;
        while(sourceVertex != null) {
            if(sourceVertex.vertexInfo.compareTo(source) == 0) {
                Edge<T,N> currentEdge = sourceVertex.firstEdge;
                Edge<T,N> previousEdge = null;
                while(currentEdge != null) {
                    if (currentEdge.toVertex.vertexInfo.compareTo(destination) == 0) {
                        // First
                        if(previousEdge == null) {
                            sourceVertex.firstEdge = currentEdge.nextEdge;
                        } else {
                            // Not first
                            previousEdge.nextEdge = currentEdge.nextEdge;
                        }
                        sourceVertex.outdeg --;
                        currentEdge.toVertex.indeg --;
                        return true;
                    }
                    previousEdge = currentEdge;
                    currentEdge = currentEdge.nextEdge;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

}
