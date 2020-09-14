public class Duck implements IAnimal {
  private String m_name;

  public Duck(String name) {
    m_name = name;
  }

  @Override
  public String makeSound() {
    return String.format("%s says: quack quack quack!", m_name);
  }
}