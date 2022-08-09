package com.cg.model;

import com.cg.model.dto.CallCardDTO;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "call_cards")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CallCard extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "callCard")
    private Set<CallCardDetail> callCardDetails;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "CallCard{" +
                "id=" + id +
                ", user=" + user.getId() +
                '}';
    }

//    public CallCardDTO toCallCardDTO() {
//        return new CallCardDTO()
//                .setId(id)
//                .setUserId(user.getId())
//                .setCallCardDetails(callCardDetails);
//    }
//
//    private boolean checkItem(Book book){
//        for (Map.Entry<Book, Integer> entry : books.entrySet())
//            if(entry.getKey().getId().equals(book.getId()))
//                return true;
//        return false;
//    }
//
//    private Map.Entry<Book, Integer> selectItem(Book book){
//        for (Map.Entry<Book, Integer> entry : books.entrySet())
//            if(entry.getKey().getId().equals(book.getId()))
//                return entry;
//        return null;
//    }
//
//    public void addBook(Book book){
//        if (!checkItem(book)){
//            books.put(book,1);
//        } else {
//            Map.Entry<Book, Integer> itemEntry = selectItem(book);
//            Integer newQuantity = itemEntry.getValue() + 1;
//            books.replace(itemEntry.getKey(),newQuantity);
//        }
//    }
//
//    public Integer countBookQuantity(){
//        Integer bookQuantity = 0;
//        for (Map.Entry<Book, Integer> entry : books.entrySet())
//            bookQuantity += entry.getValue();
//        return bookQuantity;
//    }
//
//    public Integer countItem(){
//        return books.size();
//    }

}