class Solution:
    def __init__(self):
        self.global_frame = Frame()

    def evaluate(self, expression):
        """
        :type expression: str
        :rtype: int
        """
        expr = expression.replace("(", "( ")
        expr = expression.replace(")", " )")
        return eval(expr, self.global_frame)

    def eval(self, expr, frame):



class Frame:
    def __init__(self, parent=None):
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
