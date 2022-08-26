##### _Update: 10-July-2022_

## Graph Theory

Refer to **[This Lecture](https://www.youtube.com/watch?v=09_LlHjoEiY&t=132s)**

-   A mathematical theory of the properties and applications of graphs (networks)
-   The goal is to gain an understanding of how to apply graph theory to real-world applications

**Problems**

1. Given the constraint, how many different sets of options can be chosen?
2. How many friends do person x and person y have in social networks?

<br/>

#### 1. Types of Graphs

##### 1.1. Undirected Graphs

-   Edges have no orientations(directions)

##### 1.2. Directed Graphs (Digraph): giving vertex(node), receiving edge

-   Edges have orientations
-   Have incoming nodes, outgoing nodes

##### 1.3. Weighted Graphs

-   Edges have a certain weight to represent and an arbitrary value
-   Have incoming nodes, outgoing nodes

##### 1.4. Special Graphs

-   Trees: undirected graph with no cycles
    -   Rooted Trees: has root node and direction - arborescence(out-tree), anti-arborescence(in-tree).
    -   Directed Acyclic Graphs (DAGs)
        -   Efficient to represent structures with dependencies
        -   All out-trees are DAGs, not all DAGs are out-trees
    -   Bipartite Graph: has two independent groups
        -   vertices can be split into two independent groups
        -   Efficient to represent network flow
    -   Complete Graph
        All nodes have edges to all the other edges

<br/>
#### 2. Representing Graphs (Data Structure)

##### 2.1. Adjacency Matrix

-   Pros
    -   Efficient for dense graphs,
    -   Edge weight lookup is o(1)
    -   Simplest path representation
-   Cons
    -   Requires o(v2) space
    -   Iterating over all edges takes o(v2) time

##### 2.2. Adjacency List

-   Pros
    -   Efficient for sparse graphs
    -   Iterating over all edges is efficient
-   Cons
    -   Less space efficient for denser graphs
    -   Edge weight look up is o(E)
    -   Slightly more complex graph representation

##### 2.3. Edge List: represent a graph simply as an unordered list of edges

-   Pros
    -   Space efficient for representing sparse graphs
    -   Iterating over all edges is efficient
    -   Very simple structure
-   **Cons**
    -   Less space efficient for dense graphs
    -   Edge weight lookup is o(E)

<br/>
#### 3. Common Graph Theory Problems

1. Is the graph directed or undirected?
2. Are the edges of the graph weighted?
3. Is the graph sparse or dense with edges?
4. Should I use an adjacency matrix, adjacency list, an edge list or other structures to represent the graph efficiently?

##### 3.1. Shortest path problem

-   BFS (unweighted graph)
-   Dijkstra's
-   Bellman-Ford
-   Floyd-Warshall
-   A\* algorithm etc.

3.1.1. Connectivity: does there exist a path between node-A and node-B

-   Depth First Search

3.1.2. Negative cycles: does the weighted digraph have any negative cycles?

-   Bellman-Ford
-   Floyd-Warshall
-   Can be trap but beneficial in some cases

3.1.3. Strongly Connected Components (SCCs)

-   Self-contained cycles within a directed graph where every vertex in a given cycle can reach every other vertex in the same cycle.
-   Tarjan's algorithm
-   Kosaraju's algorithm

3.1.4. Traveling Salesman Problem

-   NP-Hard meaning it's a very computationally challenging problem
-   Held-Karp
-   Branch and bound
-   Approximation algorithms

3.1.5. Bridges

-   Bridge/cut edge is an edge in a graph whose removal increases the number of connected components

3.1.6. Articulation Points

-   Articulation point/cut vertex is any node in a graph whose removal increases the number of connected components

3.1.7. Minimum Spanning Tree (MST)

-   A subset of the edges of a connected, edge-weighted graph that connects all the vertices together without any cycles and with the minimum possible total edge weight
-   Kruskal's,
-   Prim's & Boruvka's

3.1.8 Network flow: max flow

##### 3.2. Depth First Search: use "Stack"

1. Runs with the complexity of O(V+E)
2. Useful when augmented for problems of:

-   Count connected components
-   Determine connectivity
-   Find bridges/articulation points

3.2.1. DFS can do

-   Connected components problem
-   Compute a graph's minimum spanning tree
-   Detect and find cycles in a graph
-   Check if a graph is bipartite
-   Find strongly connected components
-   Topologically sort the nodes of a graph
-   Find bridges and articulation points
-   Find augmenting paths in a flow network
-   Generate mazes

##### 3.3. Breath First Search: use "Queue"

1. Runs with the complexity of O(V+E)
2. Often used as a building block on other algorithms
3. Useful finding the shortest path on unweighted graphs

3.3.1. BFS Shortest Path on a Grid

-   By adjacency list or matrix
-   Direction vectors
-   Dungeon Problem Statement
-   Alternative State representation
-   Dungeon Problem Statement

3.3.2. Topological Sort

-   Topological ordering: an ordering of the nodes in a directed graph where for each directed edge from node-A to node-B, node-a appears before node-B in the ordering

    -   School class prerequisites
    -   Program dependencies
    -   Event scheduling
    -   Assembly instructions

-   Topological sort: can find a topological ordering in o(V+E)

#### 3.4. Directed Acyclic Graphs (DAGs)

-   A graph containing a cycle cannot have a valid ordering
-   Graphs with directed edges and no cycles

3.4.1. Topological Sort Algorithm (Topsort)

-   Beginning with the selected node, do a DFS exploring only unvisited nodes
-   On the recursive callback of DFS, add the current node to the topological ordering in reverse order.

3.4.2. Shortest and Longest Paths on DAGs

-   Single Source Shortest Path (SSSP) problem can be solved on a DAG in O(V+E)
-   Can be ordered in a topological ordering
-   Longest path on DAG can be solved in O(V+E)

3.4.3. Dijkstra's Shortest Path Algorithm

-   SSSP algorithm for graphs with non-negative edge weights
-   Time complexity is typically O(E\*lob(V))
