'''
Created on Jun 24, 2017

@author: hv
'''


cost = eval(input("Tong so tien phai tra:\n"))
print("Thue= %.2f " % (0.15*cost))
print("Tip= %0.2f" %(0.075*cost))
print("Thanh toan = %0.2f"%(cost +(0.15*cost) +  (0.075*cost)))