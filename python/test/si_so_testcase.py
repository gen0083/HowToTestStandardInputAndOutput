import sys
import unittest

from test.string_io import StringIO


class SISOTestCase(unittest.TestCase):
    def stub_stdin(self, inputs):
        stdin = sys.stdin

        def cleanup():
            sys.stdin = stdin

        self.addCleanup(cleanup)
        sys.stdin = StringIO(inputs)

    def stub_stdouts(self):
        stderr = sys.stderr
        stdout = sys.stdout

        def cleanup():
            sys.stderr = stderr
            sys.stdout = stdout

        self.addCleanup(cleanup)
        sys.stderr = StringIO()
        sys.stdout = StringIO()

    def helper(self, data, expected, runner):
        self.stub_stdin(data)
        self.stub_stdouts()
        runner()
        self.assertEqual(sys.stdout.getValue(), expected)
        self.doCleanups()
