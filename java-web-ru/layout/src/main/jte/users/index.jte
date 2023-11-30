@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    @for(var user : page.getUsers())
        <h1>${user.getFirstName()} ${user.getLastName()}</h1>
        <p>ID: ${user.getId()}</p>
        <p>E-mail: ${user.getEmail()}</p>
    @endfor
`,
footer = @`
    <p href="https://github.com/Vladimir-Serebrennikov">My GitHub profile</p>
`

)