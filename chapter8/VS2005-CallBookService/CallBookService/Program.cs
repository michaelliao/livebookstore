using System;
using System.Collections.Generic;
using System.Text;
using CallBookService.localhost;

namespace CallBookService
{
  class Program
  {
    static void Main(string[] args)
    {
      Book[] books = new BookService().search("j2ee");
        foreach(Book book in books) {
          Console.WriteLine(book.author + ": " + book.name);
        }
      Console.ReadKey();
    }
  }
}
