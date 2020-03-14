#!/bin/bash

input="*.class"

array=()
while IFS=  read -r -d $'\0'; do
    array+=("$REPLY")
done < <(find . -name "${input}" -print0)
#$(find . | grep .class)

for elem in "${array[@]}"; do 
    rm -rv --preserve-root "$elem"
done

#rm -rvi --preserve-root *.class