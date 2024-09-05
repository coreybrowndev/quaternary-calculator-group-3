

const buttons = document.querySelectorAll(".key")

const Operations = Object.freeze({
    ADD:  {value: "ADD", op: '+'},
    SUBTRACT:  {value: "SUBTRACT", op: '-'},
    MULTIPLY: {value: "MULTIPLY", op: '*'},
    DIVIDE: {value: "DIVIDE", op: '/'},
});

const symbols = ['+', '-', '*', '/', '√']

let payload = {

}

function appendNumber(digit) {
    console.log('appending....', digit)
}

function setOperation(symbol) {
    const op = Object.values(Operations).find((o) => o.op === symbol)
    console.log('the operation: ', op)
}
