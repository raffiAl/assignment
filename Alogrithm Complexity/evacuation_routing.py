import heapq

# =========================
# HEURISTIC FUNCTION
# =========================
def heuristic(a, b):
    """Manhattan Distance - estimate distance to goal"""
    return abs(a[0] - b[0]) + abs(a[1] - b[1])


# =========================
# A* ALGORITHM
# =========================
def a_star(grid, start, goal):
    """A* pathfinding algorithm"""
    rows, cols = len(grid), len(grid[0])
    
    open_set = []
    heapq.heappush(open_set, (0, start))
    
    came_from = {}
    g_score = {start: 0}
    
    while open_set:
        _, current = heapq.heappop(open_set)
        
        if current == goal:
            return reconstruct_path(came_from, current)
        
        for dr, dc in [(1,0), (-1,0), (0,1), (0,-1)]:
            neighbor = (current[0] + dr, current[1] + dc)
            r, c = neighbor
            
            if 0 <= r < rows and 0 <= c < cols and grid[r][c] != "#":
                tentative_g = g_score[current] + 1
                
                if neighbor not in g_score or tentative_g < g_score[neighbor]:
                    came_from[neighbor] = current
                    g_score[neighbor] = tentative_g
                    f_score = tentative_g + heuristic(neighbor, goal)
                    heapq.heappush(open_set, (f_score, neighbor))
    
    return None


# =========================
# RECONSTRUCT PATH
# =========================
def reconstruct_path(came_from, current):
    """Rebuild path from start to goal"""
    path = [current]
    while current in came_from:
        current = came_from[current]
        path.append(current)
    return path[::-1]


# =========================
# FIND NEAREST SAFE POINT
# =========================
def find_nearest_exit(grid, start, safe_points):
    """Find nearest exit/safe point from starting position"""
    nearest_exit = None
    shortest_path = None
    min_distance = float('inf')
    
    for exit_point in safe_points:
        path = a_star(grid, start, exit_point)
        if path and len(path) < min_distance:
            min_distance = len(path)
            nearest_exit = exit_point
            shortest_path = path
    
    return nearest_exit, shortest_path


# =========================
# PRINT EVACUATION GRID
# =========================
def print_evacuation_grid(grid, path, safe_points, start, danger_zone=None):
    """Print grid with evacuation visualization"""
    path_set = set(path) if path else set()
    safe_points_set = set(safe_points)
    
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            pos = (i, j)
            
            if pos == start:
                print("P", end=" ")  # P = Person (starting position)
            elif pos in safe_points_set:
                print("E", end=" ")  # E = Exit (safe point)
            elif pos in path_set:
                print("→", end=" ")  # → = Evacuation path
            elif danger_zone and pos in danger_zone:
                print("X", end=" ")  # X = Danger zone
            else:
                print(grid[i][j], end=" ")
        print()


# =========================
# DEMO: EVACUATION ROUTING SCENARIO
# =========================
def demo_evacuation_routing():
    """
    USE CASE: EVACUATION ROUTING
    
    Scenario: Gedung kantor 10x10 dengan:
    - Person (P) di posisi (2, 2)
    - 2 Emergency Exits (E) di (0, 9) dan (9, 0)
    - Obstacles (#) = walls, furniture, collapsed areas
    - Danger zone (X) = fire spreading area
    """
    
    print("=" * 60)
    print("🚨 EVACUATION ROUTING SYSTEM - DEMO")
    print("=" * 60)
    print()
    
    # Create 10x10 grid
    rows, cols = 10, 10
    grid = [["." for _ in range(cols)] for _ in range(rows)]
    
    # Add walls/obstacles
    obstacles = [
        (1, 3), (1, 4), (1, 5),        # Collapsed wall
        (3, 6), (4, 6), (5, 6),        # Damaged corridor
        (4, 2), (4, 3), (4, 4),        # Furniture/debris
        (7, 7), (7, 8), (7, 9),        # Blocked area
        (8, 1), (8, 2),                # Structural damage
    ]
    
    for obs in obstacles:
        grid[obs[0]][obs[1]] = "#"
    
    # Define start position (person location)
    start_pos = (2, 2)
    
    # Define safe points (emergency exits)
    safe_points = [
        (0, 9),   # Exit 1: Top-right
        (9, 0),   # Exit 2: Bottom-left
    ]
    
    # Define danger zone (fire spreading)
    danger_zone = [
        (2, 7), (2, 8), (3, 7), (3, 8), (3, 9),
        (4, 8), (4, 9), (5, 8), (5, 9)
    ]
    
    print("📋 SCENARIO DETAILS:")
    print(f"  • Building Size: {rows}x{cols}")
    print(f"  • Person Location: {start_pos}")
    print(f"  • Emergency Exits: {safe_points}")
    print(f"  • Obstacles (collapsed structures): {len(obstacles)}")
    print(f"  • Danger Zone (fire): {len(danger_zone)} tiles")
    print()
    
    print("🗺️ GRID LEGEND:")
    print("  P = Person (starting position)")
    print("  E = Emergency Exit (safe point)")
    print("  → = Evacuation path")
    print("  # = Obstacle (wall/debris)")
    print("  X = Danger zone (fire)")
    print("  . = Clear area")
    print()
    
    # Find nearest safe point
    print("🔍 ANALYZING ESCAPE ROUTES...")
    print()
    
    nearest_exit, evacuation_path = find_nearest_exit(grid, start_pos, safe_points)
    
    if evacuation_path:
        exit_index = safe_points.index(nearest_exit) + 1
        distance = len(evacuation_path) - 1  # -1 because path includes start
        
        print(f"✅ EVACUATION ROUTE FOUND!")
        print(f"  • Nearest Exit: Exit {exit_index} at {nearest_exit}")
        print(f"  • Distance: {distance} steps")
        print(f"  • Escape Time (2 sec/step): {distance * 2} seconds")
        print()
        
        print("📍 DETAILED PATH:")
        for i, pos in enumerate(evacuation_path):
            if i == 0:
                print(f"  Step {i}: START at {pos}")
            elif pos == nearest_exit:
                print(f"  Step {i}: REACH SAFE POINT at {pos} ✓")
            else:
                print(f"  Step {i}: Move to {pos}")
        print()
        
        print("🗺️ EVACUATION MAP:")
        print_evacuation_grid(grid, evacuation_path, safe_points, start_pos, danger_zone)
        print()
        
        print("📊 STATISTICS:")
        print(f"  • Total Path Length: {distance} tiles")
        print(f"  • Grid Coverage: {len(evacuation_path)}/{rows*cols} tiles explored")
        safe_distance = min(
            abs(pos[0] - d[0]) + abs(pos[1] - d[1]) 
            for pos in evacuation_path 
            for d in danger_zone
        )
        print(f"  • Minimum Distance to Danger: {safe_distance} tiles")
        
    else:
        print("❌ NO EVACUATION ROUTE POSSIBLE!")
        print("   All exits are blocked or unreachable.")
    
    print()
    print("=" * 60)


# =========================
# COMPARE ALL EXITS
# =========================
def demo_compare_exits():
    """Compare distances to all available exits"""
    
    print("\n" + "=" * 60)
    print("📊 COMPARING ALL EVACUATION ROUTES")
    print("=" * 60)
    print()
    
    rows, cols = 10, 10
    grid = [["." for _ in range(cols)] for _ in range(rows)]
    
    # Add obstacles
    obstacles = [
        (1, 3), (1, 4), (1, 5),
        (3, 6), (4, 6), (5, 6),
        (4, 2), (4, 3), (4, 4),
        (7, 7), (7, 8), (7, 9),
        (8, 1), (8, 2),
    ]
    
    for obs in obstacles:
        grid[obs[0]][obs[1]] = "#"
    
    start_pos = (2, 2)
    safe_points = [(0, 9), (9, 0)]
    
    print("Analyzing all evacuation routes from START position:")
    print()
    
    for i, exit_point in enumerate(safe_points, 1):
        path = a_star(grid, start_pos, exit_point)
        if path:
            distance = len(path) - 1
            print(f"Exit {i} at {exit_point}:")
            print(f"  ✓ Reachable")
            print(f"  • Distance: {distance} steps")
            print(f"  • Evacuation Time: {distance * 2} seconds")
        else:
            print(f"Exit {i} at {exit_point}:")
            print(f"  ✗ Blocked/Unreachable")
        print()
    
    print("=" * 60)


# =========================
# RUN DEMO
# =========================
if __name__ == "__main__":
    # Main evacuation scenario
    demo_evacuation_routing()
    
    # Compare all exits
    demo_compare_exits()
    
    print("\n💡 This program demonstrates how A* algorithm can be used")
    print("   for real-world emergency evacuation routing in buildings!")
