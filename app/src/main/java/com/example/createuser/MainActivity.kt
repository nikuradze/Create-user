package com.example.createuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.createuser.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = binding.email
        val password = binding.password
        val button = binding.button

        button.setOnClickListener {
            if (password.text.toString() != "" && password.text.toString().length >=6 && email.text.toString() != ""){
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                    .addOnCompleteListener {task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "წარმატებით შეიქმნა!", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "something ain't right homie...", Toast.LENGTH_SHORT).show()
                    }

                    }
            }
        }




    }
}