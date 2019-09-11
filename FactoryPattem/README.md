<div class="article-body">
<div class="article-intro" id="content">
<h1>工厂模式</h1>

<p>工厂模式（Factory Pattern）是 Java 中最常用的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。</p>
<p>在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。</p>
<h2 class="tutheader">介绍</h2>
<p><b>意图：</b>定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。</p>
<p><b>主要解决：</b>主要解决接口选择的问题。</p>
<p><b>何时使用：</b>我们明确地计划不同条件下创建不同实例时。</p>
<p><b>如何解决：</b>让其子类实现工厂接口，返回的也是一个抽象的产品。</p>
<p><b>关键代码：</b>创建过程在其子类执行。</p>
<p><b>应用实例：</b>
1、您需要一辆汽车，可以直接从工厂里面提货，而不用去管这辆汽车是怎么做出来的，以及这个汽车里面的具体实现。
2、Hibernate 换数据库只需换方言和驱动就可以。
</p>
<p><b>优点：</b>
1、一个调用者想创建一个对象，只要知道其名称就可以了。
2、扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以。
3、屏蔽产品的具体实现，调用者只关心产品的接口。
</p>
<p><b>缺点：</b>每次增加一个产品时，都需要增加一个具体类和对象实现工厂，使得系统中类的个数成倍增加，在一定程度上增加了系统的复杂度，同时也增加了系统具体类的依赖。这并不是什么好事。</p>
<p><b>使用场景：</b>
1、日志记录器：记录可能记录到本地硬盘、系统事件、远程服务器等，用户可以选择记录日志到什么地方。
2、数据库访问，当用户不知道最后系统采用哪一类数据库，以及数据库可能有变化时。
3、设计一个连接服务器的框架，需要三个协议，"POP3"、"IMAP"、"HTTP"，可以把这三个作为产品类，共同实现一个接口。
</p>
<p><b>注意事项：</b>作为一种创建类模式，在任何需要生成复杂对象的地方，都可以使用工厂方法模式。有一点需要注意的地方就是复杂对象适合使用工厂模式，而简单对象，特别是只需要通过 new 就可以完成创建的对象，无需使用工厂模式。如果使用工厂模式，就需要引入一个工厂类，会增加系统的复杂度。</p>

<h2 class="tutheader">实现</h2>
<p>我们将创建一个 <i>Shape</i> 接口和实现 <i>Shape</i> 接口的实体类。下一步是定义工厂类 <i>ShapeFactory</i>。</p>
<p><i>FactoryPatternDemo</i>，我们的演示类使用 <i>ShapeFactory</i> 来获取 <i>Shape</i> 对象。它将向 <i>ShapeFactory</i> 传递信息（<i>CIRCLE / RECTANGLE / SQUARE</i>），以便获取它所需对象的类型。</p>
<img alt="工厂模式的 UML 图" src="https://www.runoob.com/wp-content/uploads/2014/08/factory_pattern_uml_diagram.jpg">
<h3>步骤 1</h3>
<p>创建一个接口:</p>
<div class="example">
<h2 class="example">Shape.java</h2>
<div class="example_code">
<div class="hl-main"><span class="hl-reserved">public</span><span class="hl-code"> </span><span class="hl-reserved">interface</span><span class="hl-code"> </span><span class="hl-identifier">Shape</span><span class="hl-code"> </span><span class="hl-brackets">{</span><span class="hl-code">
</span><span class="hl-types">void</span><span class="hl-code"> </span><span class="hl-identifier">draw</span><span class="hl-brackets">(</span><span class="hl-brackets">)</span><span class="hl-code">;
</span><span class="hl-brackets">}</span></div>
</div></div>
<h3>步骤 2</h3>
<p>创建实现接口的实体类。</p>

<div class="example">
<h2 class="example">Rectangle.java</h2>
<div class="example_code">
<div class="hl-main"><span class="hl-reserved">public</span><span class="hl-code"> </span><span class="hl-reserved">class</span><span class="hl-code"> </span><span class="hl-identifier">Rectangle</span><span class="hl-code"> </span><span class="hl-reserved">implements</span><span class="hl-code"> </span><span class="hl-identifier">Shape</span><span class="hl-code"> </span><span class="hl-brackets">{</span><span class="hl-code">
@</span><span class="hl-identifier">Override</span><span class="hl-code">
</span><span class="hl-reserved">public</span><span class="hl-code"> </span><span class="hl-types">void</span><span class="hl-code"> </span><span class="hl-identifier">draw</span><span class="hl-brackets">(</span><span class="hl-brackets">)</span><span class="hl-code"> </span><span class="hl-brackets">{</span><span class="hl-code">
</span><span class="hl-identifier">System</span><span class="hl-code">.</span><span class="hl-identifier">out</span><span class="hl-code">.</span><span class="hl-identifier">println</span><span class="hl-brackets">(</span><span class="hl-quotes">"</span><span class="hl-string">Inside Rectangle::draw() method.</span><span class="hl-quotes">"</span><span class="hl-brackets">)</span><span class="hl-code">;
</span><span class="hl-brackets">}</span><span class="hl-code">
</span><span class="hl-brackets">}</span></div>
</div></div>
<div class="example">
<h2 class="example">Square.java</h2>
<div class="example_code">
<div class="hl-main"><span class="hl-reserved">public</span><span class="hl-code"> </span><span class="hl-reserved">class</span><span class="hl-code"> </span><span class="hl-identifier">Square</span><span class="hl-code"> </span><span class="hl-reserved">implements</span><span class="hl-code"> </span><span class="hl-identifier">Shape</span><span class="hl-code"> </span><span class="hl-brackets">{</span><span class="hl-code">
@</span><span class="hl-identifier">Override</span><span class="hl-code">
</span><span class="hl-reserved">public</span><span class="hl-code"> </span><span class="hl-types">void</span><span class="hl-code"> </span><span class="hl-identifier">draw</span><span class="hl-brackets">(</span><span class="hl-brackets">)</span><span class="hl-code"> </span><span class="hl-brackets">{</span><span class="hl-code">
</span><span class="hl-identifier">System</span><span class="hl-code">.</span><span class="hl-identifier">out</span><span class="hl-code">.</span><span class="hl-identifier">println</span><span class="hl-brackets">(</span><span class="hl-quotes">"</span><span class="hl-string">Inside Square::draw() method.</span><span class="hl-quotes">"</span><span class="hl-brackets">)</span><span class="hl-code">;
</span><span class="hl-brackets">}</span><span class="hl-code">
</span><span class="hl-brackets">}</span></div>
</div></div>

<div class="example">
<h2 class="example">Circle.java</h2>
<div class="example_code">
<div class="hl-main"><span class="hl-reserved">public</span><span class="hl-code"> </span><span class="hl-reserved">class</span><span class="hl-code"> </span><span class="hl-identifier">Circle</span><span class="hl-code"> </span><span class="hl-reserved">implements</span><span class="hl-code"> </span><span class="hl-identifier">Shape</span><span class="hl-code"> </span><span class="hl-brackets">{</span><span class="hl-code">
@</span><span class="hl-identifier">Override</span><span class="hl-code">
</span><span class="hl-reserved">public</span><span class="hl-code"> </span><span class="hl-types">void</span><span class="hl-code"> </span><span class="hl-identifier">draw</span><span class="hl-brackets">(</span><span class="hl-brackets">)</span><span class="hl-code"> </span><span class="hl-brackets">{</span><span class="hl-code">
</span><span class="hl-identifier">System</span><span class="hl-code">.</span><span class="hl-identifier">out</span><span class="hl-code">.</span><span class="hl-identifier">println</span><span class="hl-brackets">(</span><span class="hl-quotes">"</span><span class="hl-string">Inside Circle::draw() method.</span><span class="hl-quotes">"</span><span class="hl-brackets">)</span><span class="hl-code">;
</span><span class="hl-brackets">}</span><span class="hl-code">
</span><span class="hl-brackets">}</span></div>
</div></div>
<h3>步骤 3</h3>
<p>创建一个工厂，生成基于给定信息的实体类的对象。</p>
<div class="example">
<h2 class="example">ShapeFactory.java</h2>
<div class="example_code">
<div class="hl-main"><span class="hl-reserved">public</span><span class="hl-code"> </span><span class="hl-reserved">class</span><span class="hl-code"> </span><span class="hl-identifier">ShapeFactory</span><span class="hl-code"> </span><span class="hl-brackets">{</span><span class="hl-code">
</span><span class="hl-comment">//</span><span class="hl-comment">使用 getShape 方法获取形状类型的对象</span><span class="hl-comment"></span><span class="hl-code">
</span><span class="hl-reserved">public</span><span class="hl-code"> </span><span class="hl-identifier">Shape</span><span class="hl-code"> </span><span class="hl-identifier">getShape</span><span class="hl-brackets">(</span><span class="hl-identifier">String</span><span class="hl-code"> </span><span class="hl-identifier">shapeType</span><span class="hl-brackets">)</span><span class="hl-brackets">{</span><span class="hl-code">
</span><span class="hl-reserved">if</span><span class="hl-brackets">(</span><span class="hl-identifier">shapeType</span><span class="hl-code"> == </span><span class="hl-reserved">null</span><span class="hl-brackets">)</span><span class="hl-brackets">{</span><span class="hl-code">
</span><span class="hl-reserved">return</span><span class="hl-code"> </span><span class="hl-reserved">null</span><span class="hl-code">;
</span><span class="hl-brackets">}</span><span class="hl-code">
</span><span class="hl-reserved">if</span><span class="hl-brackets">(</span><span class="hl-identifier">shapeType</span><span class="hl-code">.</span><span class="hl-identifier">equalsIgnoreCase</span><span class="hl-brackets">(</span><span class="hl-quotes">"</span><span class="hl-string">CIRCLE</span><span class="hl-quotes">"</span><span class="hl-brackets">)</span><span class="hl-brackets">)</span><span class="hl-brackets">{</span><span class="hl-code">
</span><span class="hl-reserved">return</span><span class="hl-code"> </span><span class="hl-reserved">new</span><span class="hl-code"> </span><span class="hl-identifier">Circle</span><span class="hl-brackets">(</span><span class="hl-brackets">)</span><span class="hl-code">;
</span><span class="hl-brackets">}</span><span class="hl-code"> </span><span class="hl-reserved">else</span><span class="hl-code"> </span><span class="hl-reserved">if</span><span class="hl-brackets">(</span><span class="hl-identifier">shapeType</span><span class="hl-code">.</span><span class="hl-identifier">equalsIgnoreCase</span><span class="hl-brackets">(</span><span class="hl-quotes">"</span><span class="hl-string">RECTANGLE</span><span class="hl-quotes">"</span><span class="hl-brackets">)</span><span class="hl-brackets">)</span><span class="hl-brackets">{</span><span class="hl-code">
</span><span class="hl-reserved">return</span><span class="hl-code"> </span><span class="hl-reserved">new</span><span class="hl-code"> </span><span class="hl-identifier">Rectangle</span><span class="hl-brackets">(</span><span class="hl-brackets">)</span><span class="hl-code">;
</span><span class="hl-brackets">}</span><span class="hl-code"> </span><span class="hl-reserved">else</span><span class="hl-code"> </span><span class="hl-reserved">if</span><span class="hl-brackets">(</span><span class="hl-identifier">shapeType</span><span class="hl-code">.</span><span class="hl-identifier">equalsIgnoreCase</span><span class="hl-brackets">(</span><span class="hl-quotes">"</span><span class="hl-string">SQUARE</span><span class="hl-quotes">"</span><span class="hl-brackets">)</span><span class="hl-brackets">)</span><span class="hl-brackets">{</span><span class="hl-code">
</span><span class="hl-reserved">return</span><span class="hl-code"> </span><span class="hl-reserved">new</span><span class="hl-code"> </span><span class="hl-identifier">Square</span><span class="hl-brackets">(</span><span class="hl-brackets">)</span><span class="hl-code">;
</span><span class="hl-brackets">}</span><span class="hl-code">
</span><span class="hl-reserved">return</span><span class="hl-code"> </span><span class="hl-reserved">null</span><span class="hl-code">;
</span><span class="hl-brackets">}</span><span class="hl-code">
</span><span class="hl-brackets">}</span></div>
</div></div>
<h3>步骤 4</h3>
<p>使用该工厂，通过传递类型信息来获取实体类的对象。</p>

<div class="example">
<h2 class="example">FactoryPatternDemo.java</h2>
<div class="example_code">
<div class="hl-main"><span class="hl-reserved">public</span><span class="hl-code"> </span><span class="hl-reserved">class</span><span class="hl-code"> </span><span class="hl-identifier">FactoryPatternDemo</span><span class="hl-code"> </span><span class="hl-brackets">{</span><span class="hl-code">
</span><span class="hl-reserved">public</span><span class="hl-code"> </span><span class="hl-types">static</span><span class="hl-code"> </span><span class="hl-types">void</span><span class="hl-code"> </span><span class="hl-identifier">main</span><span class="hl-brackets">(</span><span class="hl-identifier">String</span><span class="hl-brackets">[</span><span class="hl-brackets">]</span><span class="hl-code"> </span><span class="hl-identifier">args</span><span class="hl-brackets">)</span><span class="hl-code"> </span><span class="hl-brackets">{</span><span class="hl-code">
</span><span class="hl-identifier">ShapeFactory</span><span class="hl-code"> </span><span class="hl-identifier">shapeFactory</span><span class="hl-code"> = </span><span class="hl-reserved">new</span><span class="hl-code"> </span><span class="hl-identifier">ShapeFactory</span><span class="hl-brackets">(</span><span class="hl-brackets">)</span><span class="hl-code">;
</span><span class="hl-comment">//</span><span class="hl-comment">获取 Circle 的对象，并调用它的 draw 方法</span><span class="hl-comment"></span><span class="hl-code">
</span><span class="hl-identifier">Shape</span><span class="hl-code"> </span><span class="hl-identifier">shape1</span><span class="hl-code"> = </span><span class="hl-identifier">shapeFactory</span><span class="hl-code">.</span><span class="hl-identifier">getShape</span><span class="hl-brackets">(</span><span class="hl-quotes">"</span><span class="hl-string">CIRCLE</span><span class="hl-quotes">"</span><span class="hl-brackets">)</span><span class="hl-code">;
</span><span class="hl-comment">//</span><span class="hl-comment">调用 Circle 的 draw 方法</span><span class="hl-comment"></span><span class="hl-code">
</span><span class="hl-identifier">shape1</span><span class="hl-code">.</span><span class="hl-identifier">draw</span><span class="hl-brackets">(</span><span class="hl-brackets">)</span><span class="hl-code">;
</span><span class="hl-comment">//</span><span class="hl-comment">获取 Rectangle 的对象，并调用它的 draw 方法</span><span class="hl-comment"></span><span class="hl-code">
</span><span class="hl-identifier">Shape</span><span class="hl-code"> </span><span class="hl-identifier">shape2</span><span class="hl-code"> = </span><span class="hl-identifier">shapeFactory</span><span class="hl-code">.</span><span class="hl-identifier">getShape</span><span class="hl-brackets">(</span><span class="hl-quotes">"</span><span class="hl-string">RECTANGLE</span><span class="hl-quotes">"</span><span class="hl-brackets">)</span><span class="hl-code">;
</span><span class="hl-comment">//</span><span class="hl-comment">调用 Rectangle 的 draw 方法</span><span class="hl-comment"></span><span class="hl-code">
</span><span class="hl-identifier">shape2</span><span class="hl-code">.</span><span class="hl-identifier">draw</span><span class="hl-brackets">(</span><span class="hl-brackets">)</span><span class="hl-code">;
</span><span class="hl-comment">//</span><span class="hl-comment">获取 Square 的对象，并调用它的 draw 方法</span><span class="hl-comment"></span><span class="hl-code">
</span><span class="hl-identifier">Shape</span><span class="hl-code"> </span><span class="hl-identifier">shape3</span><span class="hl-code"> = </span><span class="hl-identifier">shapeFactory</span><span class="hl-code">.</span><span class="hl-identifier">getShape</span><span class="hl-brackets">(</span><span class="hl-quotes">"</span><span class="hl-string">SQUARE</span><span class="hl-quotes">"</span><span class="hl-brackets">)</span><span class="hl-code">;
</span><span class="hl-comment">//</span><span class="hl-comment">调用 Square 的 draw 方法</span><span class="hl-comment"></span><span class="hl-code">
</span><span class="hl-identifier">shape3</span><span class="hl-code">.</span><span class="hl-identifier">draw</span><span class="hl-brackets">(</span><span class="hl-brackets">)</span><span class="hl-code">;
</span><span class="hl-brackets">}</span><span class="hl-code">
</span><span class="hl-brackets">}</span></div>
</div></div>
<h3>步骤 5</h3>
<p>执行程序，输出结果：</p>
<pre class="prettyprint prettyprinted"><span class="typ">Inside</span><span class="pln"> </span><span class="typ">Circle</span><span class="pun">::</span><span class="pln">draw</span><span class="pun">()</span><span class="pln"> method</span><span class="pun">.</span><span class="pln">
</span><span class="typ">Inside</span><span class="pln"> </span><span class="typ">Rectangle</span><span class="pun">::</span><span class="pln">draw</span><span class="pun">()</span><span class="pln"> method</span><span class="pun">.</span><span class="pln">
</span><span class="typ">Inside</span><span class="pln"> </span><span class="typ">Square</span><span class="pun">::</span><span class="pln">draw</span><span class="pun">()</span><span class="pln"> method</span><span class="pun">.</span></pre>
</div>
</div>
