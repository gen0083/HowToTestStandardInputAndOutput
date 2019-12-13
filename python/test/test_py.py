import src.py
from test.si_so_testcase import SISOTestCase


class MyTestCase(SISOTestCase):
    def test_something(self):
        self.helper("3\n1\n2 3\n4 5 6\n ", "1\n5\n15\n", src.py.test_func)
