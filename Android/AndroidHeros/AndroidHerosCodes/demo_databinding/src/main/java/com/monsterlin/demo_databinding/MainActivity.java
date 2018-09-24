package com.monsterlin.demo_databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.monsterlin.demo_databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Employee employee = new Employee("monster", "lin");
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * 生成规则：
         * layout : activity_main.xml
         * binding :ActivityMainBinding
         */
         binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setEmployee(employee);

        binding.setPresenter(new Presenter());
    }


    public class Presenter{
        //方法引用：必须与原来的Listener完全一致

        public void onTextChanged(CharSequence s , int start ,int before ,int count ){
            employee.setFirstName(s.toString());
            binding.setEmployee(employee);
        }

        public void onClick(View view){
            Toast.makeText(MainActivity.this,"点到了",Toast.LENGTH_SHORT).show();
        }

        public void onClickListenerBinding(Employee employee){
            Toast.makeText(MainActivity.this,employee.getLastName(),Toast.LENGTH_SHORT).show();
        }
    }
}
