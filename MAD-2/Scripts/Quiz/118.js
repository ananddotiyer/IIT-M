let student = [
    {id: 1, name: "Hari", scholarship: true},
    {id: 2, name: "Ram", scholarship: false},
    {id: 3, name: "Rahim", scholarship: true},
]

const newData = [...student]

const prevIndex = student.findIndex(item => item.scholarship === false);

newData.splice(prevIndex, 1)
console.log(newData)