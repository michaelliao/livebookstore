# file: Greeting.rb

require 'java'

include_class 'example.chapter9.Greeting'

class JRubyGreeting < Greeting

  def getMessage()
    return @@msg
  end

  def setMessage(msg)
    @@msg = msg
  end

end

JRubyGreeting.new
