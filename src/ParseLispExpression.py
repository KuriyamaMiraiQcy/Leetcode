class Solution:
    def evaluate(self, expression):
        """
        :type expression: str
        :rtype: int
        """
        expr = expression.split()
        global_frame= Frame(None)
        self.read(global_frame, expr)
        return global_frame.eval()

    def read(self, frame, expression):
        if len(expression) == 0:
            return frame

        if len(expression) == 1:
            return Frame(frame)

        if expression[0][0] == '(':
            expression[0].replace('(', "")
            if expression[0] == "add":
                child = addFunc(expression[1:])
            elif expression[0] == "mult":
                child = mulFunc(expression[1:])
            else:
                child = letFunc(expression[1:])
            frame.setChildFrame(child)
            return frame

        if expression[0][-1] != ')' and expression[1][-1] != ')':
            frame.define(expression[0], expression[1])
            self.read(frame, expression[1:-1])


    def addFunc(self, expr):


class Frame:
    def __init__(self, parent):
        self.bindings = {}
        self.parent = parent
        self.child = None

    def define(self, symbol, value):
        self.bindings[symbol] = value

    def lookup(self, symbol):
        if symbol in self.bindings:
            return self.bindings[symbol]
        else:
            return self.parent.lookup(symbol)

    def setChildFrame(self, child):
        child.parent = self

class addFrame(Frame):
    def eval(self):
        result = 0
        for symbol in self.bindings:
            if isinstance(self.bindings[symbol], Frame):
                result += self.bindings[symbol].eval()
            else:
                result += self.bindings[symbol]
        return result

class mulFrame(Frame):
    def eval(self):
        result = 1
        for symbol in self.bindings:
            if isinstance(self.bindings[symbol], Frame):
                result *= self.bindings[symbol].eval()
            else:
                result *= self.bindings[symbol]
        return result

class letFrame(Frame):
    def eval(self):
        return self.child.eval()
