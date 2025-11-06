def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr)//2][1]   # pivot chosen by middle element's score
    less = [x for x in arr if x[1] < pivot]
    equal = [x for x in arr if x[1] == pivot]
    greater = [x for x in arr if x[1] > pivot]
    return quick_sort(less) + equal + quick_sort(greater)

students = [
    ("Andi", 78),
    ("Budi", 65),
    ("Citra", 85),
    ("Dewi", 72),
    ("Eka", 90)
]

sorted_by_quick = quick_sort(students)
print(sorted_by_quick)
