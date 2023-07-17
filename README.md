This is a prototype project for creating an intermediate DLL to use with the JNI to communicate with HyperOrder
using its API. A Java class is provided to interface to the JNI module, and a simple test to demonstrate
the software.

Using the JNI DLL you will be able to execute trades using most of the more popular trading platforms via
the HyperOrder Host program (http://www.hypertrader.it/hyperorder.shtml), directly in your own Java trading
programs. This will allow you to develop sophisticated trading systems and deliver them to all compatible
trading platforms without coding for the individual interfaces.

The code is operational but not properly tested. As the original code was created many years ago, later
additions to the API have not been implemented, however all of the key methods are available. It is easy to
add methods by either hand coding the additions into the cpp sources following the existing examples, or for
the more adventurous, have a bash at JPeerGen which does the job for you automatically.

The code is open source. In the spirit of this, if you further develop the code, you should make your code
available for free. Otherwise, use it as an example and build your own version based on what you see.