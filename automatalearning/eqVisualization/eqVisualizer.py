from PySimpleAutomata import automata_IO
import os, re

os.environ["PATH"] += os.pathsep + 'C:\Program Files (x86)\Graphviz\release\bin'


__location__ = os.path.realpath(
    os.path.join(os.getcwd(), os.path.dirname(__file__)))


for filename in os.listdir(__location__):
    if re.match(".*hypo.json", filename):
        currdfa = automata_IO.dfa_json_importer(os.path.join(__location__, filename))
        automata_IO.dfa_to_dot(currdfa, filename.split('.')[0], __location__)
        



