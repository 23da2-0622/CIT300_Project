# CIT300 Graded Practical Assignment 1
## University Student Record and Campus Route Management System

### Group Members

| Name | Student ID | Responsibility |
|------|-----------|----------------|
| [Pramodya Milinda] | [23da2-0] | Student Records + Linked List |
| [Dulshan] | [23da2-0] | Stack + Queue |
| [Bimal] | [23da2-0] | BST/AVL + Hashing |
| [M.D.M.Madhushika Sandamali] | [23da2-0622] | Graph + BFS/DFS |

---

## Member 4 — [M.D.M.Madhushika Sandamali] ([23da2-0622])

### Responsibilities
- Graph implementation using Adjacency List
- Add/Remove campus locations
- Add/Remove campus connections (roads)
- Display campus network
- BFS traversal of campus locations
- DFS traversal of campus locations
- Input validation for all graph operations

### Contribution
- Created `Graph.java` using `Map<String, List<String>>` (Adjacency List)
- Implemented `addLocation()` with duplicate handling
- Implemented `removeLocation()` that also removes the location from all neighbour lists
- Implemented `addConnection()` and `removeConnection()` (undirected graph)
- Implemented `displayConnections()` to show the campus network
- Implemented `bfs()` using Queue
- Implemented `dfs()` using recursion
- Integrated graph menu (options 10–15) into `Main.java`
- Tested all graph operations including edge cases (duplicate locations, missing locations, invalid connections)

### Files
- `Graph.java`
- (Main.java graph menu section)