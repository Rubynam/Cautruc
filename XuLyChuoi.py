'''
Created on Jun 24, 2017

@author: hv
'''
s1 = input("Nhap chuoi s1 :\n")
s2 = input("Nhap chuoi s2 :\n")
s3 = input("Nhap chuoi s3 :\n")
input_index = eval(input("Nhap index :\n"))

print("chieu dai chuoi s1: " ,len(s1))
print("chieu dai chuoi s2: " ,len(s2))
print("chieu dai chuoi s3: " ,len(s3))

print("chuoi s4" , s1[input_index:])
print("chuoi s2 lap lai 2 lan: " ,s2*2)