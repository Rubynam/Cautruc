'''
Created on Jun 24, 2017

@author: hv
'''

s1 = eval(input("Lai xuat 1 nam: \n"))
s2 = eval(input("So tien gui : \n"))
s3 = eval(input("So thang gui : \n"))

tien_lai = (s2*s3)*(s1/100/12)
print("Tien Lai = " ,tien_lai)
print("Tien von + Lai= %.0f "%(s2+tien_lai))