# This
def test_function(n):

    N = xrange(n)
    #Comment
    log_N = xrange(int(math.log(n,2)))
    #Stack record
    for i in N:
        #nested stack record that loops from 0 to floor
        for j in log_N:
            print("This statement prints n * log(n) times.")
    #while
    k = n
    while k > 1:
        print("But this statement only prints log(n) times.")
        k /= 2
    print("Since n * log(n) is bigger complexity, the whole" 
          "function is O(n * log(n).")
