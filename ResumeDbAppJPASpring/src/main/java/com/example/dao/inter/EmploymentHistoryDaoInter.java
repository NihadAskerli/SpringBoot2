/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.inter;

import com.example.entity.EmploymentHistory;


import java.util.List;

public interface EmploymentHistoryDaoInter {
    public  List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);
}
