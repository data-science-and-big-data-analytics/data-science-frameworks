#!/usr/bin/env python3

from concepts import Context


# Read context from the string containing the FCA data
c = Context.fromstring('''
           |human|knight|king |mysterious|
King Arthur|  X  |  X   |  X  |          |
Sir Robin  |  X  |  X   |     |          |
holy grail |     |      |     |     X    |
''')


# Derive common properties
print(c.intension(['King Arthur', 'Sir Robin']))
# Will result: ('human', 'knight')

print(c.extension(['knight', 'mysterious']))
# Will result: ()


print()


# Get closest matching object-properties pairs
print(c['Sir Robin', 'holy grail'])
# Will result: (('King Arthur', 'Sir Robin', 'holy grail'), ())

print(c['king', ])  # Notice, that the , is important!
# Will result: (('King Arthur',), ('human', 'knight', 'king'))


print()


# Iteration over the concept lattics of all pairs
for extent, intent in c.lattice:
    print('%r %r' % (extent, intent))
# Will print:
# () ('human', 'knight', 'king', 'mysterious')
# ('King Arthur',) ('human', 'knight', 'king')
# ('holy grail',) ('mysterious',)
# ('King Arthur', 'Sir Robin') ('human', 'knight')
# ('King Arthur', 'Sir Robin', 'holy grail') ()


# Uncomment following code if you want a visualization of the FCA
# Make sure graphviz is installed!
#fig = c.lattice.graphviz()
#fig.render()
