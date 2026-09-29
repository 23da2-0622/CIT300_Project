# CIT300 Graded Practical Assignment 1
## University Student Record and Campus Route Management System

### Group Members

| Name | Student ID | Responsibility |
|---|---|---|
| [Pramodya Milinda] | [23da2-0252] | Student Records + Linked List |
| [R.L.M.B.T.Ekanayaka] | [23da2-0911] | Stack + Queue |
| [A.k.u.s.d.jayawardana] | [23da2-0519] | BST/AVL + Hashing |
| [M.D.M.Madhushika Sandamali] | [23da2-0622] | Graph + BFS/DFS |

---

## Member 1 — [Pramodya Milinda] ([23da2-0252])

### Responsibilities
- Student Record implementation using Linked List
- Managing student details (Add, Update, Delete, Search)

### Contribution
- Created student record structures and basic list management functions.

---

## Member 2 — [R.L.M.B.T.Ekanayaka] ([23da2-0911])

### Responsibilities
- Stack and Queue implementations
- Data structure operations for workflow management

### Contribution
- Implemented Stack and Queue utilities used across the project.

---

## Member 3 — [A.k.u.s.d.jayawardana] ([23da2-0519])

### Responsibilities
- BST/AVL Tree implementations
- Hashing structures for data retrieval

### Contribution
- Developed tree algorithms and hashing mechanisms for fast searching.

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
