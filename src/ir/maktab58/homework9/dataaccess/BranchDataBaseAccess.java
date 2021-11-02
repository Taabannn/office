package ir.maktab58.homework9.dataaccess;

import ir.maktab58.homework9.models.Branch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Taban Soleymani
 */
public class BranchDataBaseAccess extends DataBaseAccess {
    public BranchDataBaseAccess() {
        super();
    }

    public ArrayList<Branch> getAllBranches(){
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from branch");
                ArrayList<Branch> branches = new ArrayList<>();
                while (resultSet.next()) {
                    Branch branch = new Branch(resultSet.getInt(1), resultSet.getString(2),
                                        resultSet.getString(3), resultSet.getString(4),
                                        resultSet.getString(5), resultSet.getString(6));
                    branches.add(branch);
                }
                return branches;
            } catch (SQLException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return null;
    }
}
