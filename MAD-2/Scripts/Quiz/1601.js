var y = 15

const Obj1 = {
    y: 15,
    getY: () => {
        return this.y;
    },
    obj3: {
        y: 45,
        getY: () => {
            return this.y;
        },
    }
}
console.log(Obj1.obj3.getY(), Obj1.getY())