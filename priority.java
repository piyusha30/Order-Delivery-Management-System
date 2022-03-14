package cms;

import java.util.Comparator;

 class priority implements Comparator<details> {
  //djikstra t = new djikstra();

  @Override
  public int compare(details o1, details o2) {
   djikstra t = new djikstra();

  if( t.shortest(0,o1.weight)>=t.shortest(0,o2.weight)){
   return 1;
  }else if(t.shortest(0,o1.weight)<t.shortest(0,o2.weight)){
   return -1;
  }
return 0;
  }


}
