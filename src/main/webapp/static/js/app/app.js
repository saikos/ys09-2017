const PI = 3.14; //ES6 constant

let areaOfCircle //block-scoped variable
        = (radius) => PI * radius * radius; //ES6 arrow function with expression body


class Shape { //ES6 class
    
    constructor(name = 'Shape') { //ES6 default parameter value
        this.name = name;
    }
    
    area() { 
        return 0.0;
    }
    
    toString() {
        return `${this.name} with area ${area()}`; //ES6 string interpolation
    }
}

class Circle extends Shape { //ES6 inheritance 
    
    constructor(radius) {
        super('Circle'); //ES6 call to super
        this.radius = radius;
    }
    
    area() {
        return areaOfCircle(this.radius);
    }
}

class Square extends Shape {
    constructor(side) {
        super('Square');
        this.side = side;
    }
    
    area() {
        return this.side * this.side; 
    }
}

class LiveCircle extends Shape {
    
    constructor(radius) {
        super('LiveCircle');
        this.radius = ko.observable(radius); //knockout observable
        this.area = ko.pureComputed(() => PI * this.radius() * this.radius()); //knockout computed observable
    }
}

class LiveSquare extends Shape {
    constructor(side) {
        super('LiveSquare');
        this.side = ko.observable(side);
        this.area = ko.pureComputed(() => this.side() * this.side());        
    }
}

let shapes = [
    new Circle(1.0),
    new Square(2.0),
    new LiveCircle(1.0),
    new LiveSquare(2.0)
];

let areas = new Set(); //ES6 new collection (along with Map, WeakSet, WeakMap)
shapes.forEach(shape => areas.add(shape.area())); // ES6 lambdas

areas.size === 2 ? console.log("Two areas held in set!") : console.log("Set error!");

let ta1 = _.reduce(shapes, function(sum, shape) { //sum of all shape areas (_ is lodash)
    return sum + shape.area();
}, 0);

let totalArea = function(shape1, ...otherShapes) { //ES6 rest operator
    return shape1.area() + 
           _.reduce(otherShapes, (sum, shape) => sum + shape.area(), 0);
};

let ta2 = totalArea(...shapes); //ES6 spread operator

ta1 === ta2 ? console.log("Rest/Spread working!") : console.log("Rest/Spread error!");

let [circle, square, liveCircle, liveSquare] = shapes; //ES6 destructuring

let vm = {circle, square, liveCircle, liveSquare}; //ES6 property shorthand
//vm = { circle: circle, square: square, ... };

let datasets = { 
    list: ko.observableArray([]),
    load() { //ES6 enhanced object literals
        var self = this; //this is available here
        new Promise((resolve, reject) => { //ES6 promises
            $.ajax({
                url: 'http://www.opendatacloud.gr/api/v1/datasets',
                type: "GET",
                dataType: "jsonp"
            }).done(response => {
                resolve(response.data);
            }).fail(error => reject(error));
        }).then(data => {
            data.forEach(ds => self.list.push(ds));
        });
    }
};

//vm = Object.assign(vm, datasets); //ES6 Object property assignment
vm.datasets = datasets;

ko.applyBindings(vm);  //activate knockout with the vm (view model)